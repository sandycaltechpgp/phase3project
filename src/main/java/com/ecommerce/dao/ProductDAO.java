package com.ecommerce.dao;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.hibernate.transform.ResultTransformer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Repository
@Component
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public Product getProductById(long id) {
        String strId = String.valueOf(id);
        List<Product> list = this.sessionFactory.getCurrentSession().createQuery("from Product where id=" + strId).list();
        if (list.size() > 0)
            return (Product) list.get(0);
        else
            return null;

    }


    @SuppressWarnings("unchecked")
    public void updateProduct(Product product) {
        String sql = "";
        if (product.getID() == 0)
            this.sessionFactory.getCurrentSession().save(product);
        else if (product.getID() > 0) {
            sql = "update Product set name=:name, price=:price, category_id=:category_id where " +
                    " ID=:id";
            Query query = this.sessionFactory.getCurrentSession().createQuery(sql);
            query.setParameter("name", product.getName());
            query.setParameter("price", product.getPrice());
            query.setParameter("category_id", product.getCategoryId());
            query.setParameter("id", product.getID());

            query.executeUpdate();
        }

    }


    @SuppressWarnings("unchecked")
    public void deleteProduct(long id) {
        // delete all purchase items for this product before deleting this product
        // Pending:Purchase total is not updated in the purchase total - it shows the old value

        String sql = "";
        sql = "delete from PurchaseItem where product_id=:id";
        Query query = this.sessionFactory.getCurrentSession().createQuery(sql);
        query.setParameter("id", id);

        sql = "delete from Product where ID=:id";
        query = this.sessionFactory.getCurrentSession().createQuery(sql);
        query.setParameter("id", id);

        query.executeUpdate();

    }

    @SuppressWarnings("unchecked")
    public List<Product> getAllProducts() {
        List<Product> list = this.sessionFactory.getCurrentSession().createQuery("from Product order by name").list();

        return list;
    }


    public List<ProductDTO> getAllProductsWithJoin() {

        String sql = "SELECT p.ID, p.name, p.price, p.date_added, c.name as category from eproduct p, category c where p.category_id=c.ID order by p.name";
        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
        List list = query.setResultTransformer(new ResultTransformer() {
            @Override
            public Object transformTuple(
                    Object[] tuple,
                    String[] aliases) {
                return new ProductDTO(
                        (BigInteger) tuple[0], (String) tuple[1], (BigDecimal) tuple[2], (Date) tuple[3], (String) tuple[4]
                );
            }

            @Override
            public List transformList(List tuples) {
                return tuples;
            }
        }).list();

        return list;
    }


    public List<ProductDTO> getAllProducts(String pname, String cname) {

        String sql = "SELECT p.ID, p.name, p.price, p.date_added, c.name as category from eproduct p, category c where p.category_id=c.ID order by p.name";

        if ((pname != null && !pname.isEmpty()) && (cname != null && !cname.isEmpty()))
            sql = "SELECT p.ID, p.name, p.price, p.date_added, c.name as category from eproduct p, category c where p.category_id=c.ID and p.name like '%" + pname + "%' c.name like '%" + cname + "%' order by p.name";
        else if ((pname != null && !pname.isEmpty()) && (cname == null || cname.isEmpty()))
        sql = "SELECT p.ID, p.name, p.price, p.date_added, c.name as category from eproduct p, category c where p.category_id=c.ID and p.name like '%" + pname + "%' order by p.name";
        else if ((pname == null || pname.isEmpty()) && (cname != null && !cname.isEmpty()))
        sql = "SELECT p.ID, p.name, p.price, p.date_added, c.name as category from eproduct p, category c where p.category_id=c.ID and c.name like '%" + cname + "%' order by p.name";

        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
        List list = query.setResultTransformer(new ResultTransformer() {
            @Override
            public Object transformTuple(
                    Object[] tuple,
                    String[] aliases) {
                return new ProductDTO(
                        (BigInteger) tuple[0], (String) tuple[1], (BigDecimal) tuple[2], (Date) tuple[3], (String) tuple[4]
                );
            }

            @Override
            public List transformList(List tuples) {
                return tuples;
            }
        }).list();

        return list;
    }
}
