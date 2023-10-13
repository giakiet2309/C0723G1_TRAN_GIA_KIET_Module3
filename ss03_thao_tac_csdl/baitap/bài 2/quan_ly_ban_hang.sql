create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
	c_id int primary key auto_increment,
    name varchar(25),
    c_age tinyint
);
create table orders(
	o_id int primary key auto_increment,
    c_id int,
    o_date datetime,
    total_price int,
    foreign key (c_id) references customer(c_id)
);
create table product(
	p_id int primary key auto_increment,
    p_name varchar(25),
    p_price int
);
create table order_detail(
	o_id int,
    p_id int,
    od_qty int,
    foreign key (o_id) references orders(o_id),
    foreign key (p_id) references product(p_id),
    primary key (p_id, o_id)
);
insert into customer (name, c_age)
values
	("Minh Quân", 10),
	("Ngọc oanh", 20),
	("Hồng Hà", 50);
    
insert into orders (c_id, o_date)
values
	(1,"2006-03-21"),
	(2,"2006-03-23"),
	(1,"2006-03-16");
    
insert into product (p_name,p_price)
values
	("Máy lạnh",3),
	("Tủ lạnh",5),
	("Điều hòa",7),
	("Quạt",1),
	("Bếp điện",2);
    
insert into order_detail (o_id,p_id,od_qty)
values
	(1,1,3),
	(1,3,7),
	(1,4,2),
	(2,1,1),
	(3,1,8),
	(2,5,4),
	(2,3,3);
    
--  Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o_id, o_date, total_price
from orders;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khác 
select customer.c_id, customer.name, product.p_name
from customer
inner join orders on orders.c_id = customer.c_id
inner join order_detail on order_detail.o_id = orders.o_id
inner join product on product.p_id = order_detail.p_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào 
select customer.c_id, customer.name
from customer
left join orders on orders.c_id = customer.c_id
where orders.o_id is null
group by customer.c_id;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của 
-- từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice) 
select 
	orders.o_id as "Mã hóa đơn",
    orders.o_date as "Ngày bán",
    sum(order_detail.od_qty * product.p_price) as "Tổng hóa đơn"
from orders
inner join order_detail on order_detail.o_id = orders.o_id
inner join product on product.p_id = order_detail.p_id
group by orders.o_id;