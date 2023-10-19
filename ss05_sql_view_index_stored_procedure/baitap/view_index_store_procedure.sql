create database demo;
use demo;
create table products  (
	id int auto_increment primary key,
	product_code varchar(50) not null,
	product_name varchar(50) not null,
	product_price double not null,
	product_amount int not null,
	product_description varchar(50) not null,
	product_status bit
);

insert into products (product_code, product_name, product_price, product_amount, product_description, product_status)
values
    ('P001', 'Product A', 19.99, 100, 'Description for Product A', 1),
    ('P002', 'Product B', 29.99, 50, 'Description for Product B', 1),
    ('P003', 'Product C', 9.99, 200, 'Description for Product C', 0),
    ('P004', 'Product D', 39.99, 75, 'Description for Product D', 1),
    ('P005', 'Product E', 49.99, 30, 'Description for Product E', 1);


alter table products add index idx_p_code(product_code);

alter table products add index idx_p_name_price(product_name,product_price);

explain
select *
from products
where product_code ='P001';

explain
select *
from products
where product_name like '%A' and product_price = 19.99 ;

-- 4. Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view view_product as
select product_code, product_name, product_price, product_status
from products;

create or replace view view_product as
select product_code, product_name
from products;

drop view view_product;

-- 5a. Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product.
delimiter //
create procedure get_all_products()
begin
select *
from products;
end //
delimiter ;

call get_all_products();

-- 5b. Tạo store procedure thêm một sản phẩm mới.
delimiter //
create procedure add_new_product(
	new_product_code varchar(50),
	new_product_name varchar(50),
	new_product_price double,
	new_product_amount int,
	new_product_description varchar(50),
	new_product_status bit
    )
begin
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status)
values
    (new_product_code,new_product_name, new_product_price, new_product_amount, new_product_description, new_product_status);
end //
delimiter ;

call add_new_product('P006', 'Product F', 59.99, 10, 'Description for Product F', 1);

-- 5c. Tạo store procedure sửa thông tin sản phẩm theo id.

delimiter //
create procedure edit_product(edit_id int,
	new_product_code varchar(50),
	new_product_name varchar(50),
	new_product_price double,
	new_product_amount int,
	new_product_description varchar(50),
	new_product_status bit
    )
    begin
    update products
    set product_code = new_product_code,
    product_name = new_product_name,
	product_price = new_product_price,
    product_amount = new_product_amount,
    product_description = new_product_description,
    product_status = new_product_status
    where id = edit_id;
    end //
delimiter ;

call edit_product(5,'P005A', 'Product EA', 59.99, 10, 'Description for Product EA', 1);

delimiter //
create 	procedure del_product(del_id int)
begin
delete from products where id=del_id;
end //
delimiter ;

call del_product(3);