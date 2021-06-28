CREATE TABLE cart_items (
  id INT PRIMARY KEY,
  product_id VARCHAR(250) NOT NULL,
  customer_id VARCHAR(250) NOT NULL,
  quantity INT NOT NULL
);

CREATE TABLE dps_profile (
  profile_id INT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  pwd VARCHAR(250) NOT NULL
);

CREATE TABLE dcs_product (
  prod_id VARCHAR(250) PRIMARY KEY,
  prod_name VARCHAR(250) NOT NULL,
  prod_short_desc VARCHAR(250)
);


INSERT INTO dcs_product (prod_id, prod_name, prod_short_desc) VALUES
  ('prd123', 'Jeans', 'Denim Jeanks'),
  ('prd456', 'Shirt', 'Cotton Shirts'),
  ('prd789', 'T-Shirt', 'Funky T-shirts');