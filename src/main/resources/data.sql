
/*
THIS DATA WILL BE LOADED ON THE STARTUP OF THE APPLICATION.
*/


/*
inserting an Admin user
username: admin
password: admin

*/
INSERT INTO admin(ID,admin_id,admin_pwd) VALUES (1,'admin', 'admin')

/*
 inserting product categories
*/
INSERT INTO category (ID,name) VALUES (1,'Category1')
INSERT INTO category (ID,name) VALUES (2,'Category2')
INSERT INTO category (ID,name) VALUES (3,'Category3')
INSERT INTO category (ID,name) VALUES (4,'Category4')
INSERT INTO category (ID,name) VALUES (5,'Category5')

/*
inserting products
*/
INSERT INTO eproduct (ID, category_id, date_added, name, price) VALUES (1, 1, now(), 'Product1', 1000)
INSERT INTO eproduct (ID, category_id, date_added, name, price) VALUES (2, 2, now(), 'Product2', 1001)
INSERT INTO eproduct (ID, category_id, date_added, name, price) VALUES (3, 3, now(), 'Product3', 1003)
INSERT INTO eproduct (ID, category_id, date_added, name, price) VALUES (4, 4, now(), 'Product4', 1004)
INSERT INTO eproduct (ID, category_id, date_added, name, price) VALUES (5, 1, now(), 'Product5', 1005)
