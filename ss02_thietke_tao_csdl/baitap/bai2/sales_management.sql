create database sales_management;
use sales_management;
create table `products` (
	`product_id` int primary key auto_increment,
    `product_name` varchar(200),
    `product_price` int
);
create table `customers` (
	`customer_id` int primary key auto_increment,
    `customer_name` varchar(200),
    `customer_age` int
);
create table `orders` (
	`order_id` int primary key auto_increment,
    `customer_id` int,
    `order_date` datetime,
    `order_total_price` int,
    foreign key (`customer_id`) references `customers`(`customer_id`)
);
create table `order_details`(
	`order_id` int,
    `product_id` int,
    `order_quantity` int,
    primary key(`order_id`, `product_id`),
    foreign key (`order_id`) references `orders` (`order_id`),
    foreign key (`product_id`) references `products` (`product_id`)
);