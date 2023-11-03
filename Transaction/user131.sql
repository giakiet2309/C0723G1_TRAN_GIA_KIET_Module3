create database `user131`;
use `user131`;
create table `users`(
	`user_id` int primary key auto_increment,
    `user_name` varchar(50),
    `age` int,
    `nation` varchar(50),
    `is_delete` bit(1) default 0
);
insert into `users`(`user_name`, `age`,`nation`)
value 
	("Kiệt", 30, "Việt Nam"),
	("Kiệt", 21, "Mỹ"),
	("Kiệt", 32, "Anh"),
	("Kiệt", 55, "Pháp"),
	("Kiệt", 43, "Lào"),
	("Kiệt", 11, "Thái");
    
    delimiter //
    create procedure display_user()
    select `user_id`, `user_name`, `age`, `nation` from `users`
    where `is_delete` = 0;
    end //
    delimiter ;
    
    delimiter //
    create procedure get_user(`id` int)
    select `user_id`, `user_name`, `age`, `nation` from `users`
    where `is_delete` = 0 and `user_id` = `id`;
    end //
    delimiter ;
    
	delimiter //
    create procedure edit_user(`id` int, `new_name` varchar(50), `new_age` int, `new_nation` varchar(50))
    update `users`
    set
		`user_name` = `new_name`,
        `age` = `new_age`,
        `nation` = `new_nation`
    where (`user_id` = `id`);
    end //
    delimiter ;
    
	delimiter //
    create procedure delete_user(`id` int)
    update `users`
    set
		`is_delete` = 1
    where (`user_id` = `id`);
    end //
    delimiter ;


    
    call display_user();
    call get_user(1);
    call edit_user(1, " Kiệt", 99, "núi");
    call delete_user(1);