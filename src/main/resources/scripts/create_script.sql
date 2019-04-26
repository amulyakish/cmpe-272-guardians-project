CREATE TABLE `Book` (
	`book_id` INT NOT NULL AUTO_INCREMENT,
	`ISBN` VARCHAR(255) NOT NULL UNIQUE,
	`title` VARCHAR(500) NOT NULL,
	`price` DECIMAL NOT NULL,
	PRIMARY KEY (`book_id`)
);

CREATE TABLE `Inventory` (
	`inventory_id` INT NOT NULL AUTO_INCREMENT,
	`book_id` INT,
	`no_of_copies` INT NOT NULL,
	PRIMARY KEY (`inventory_id`)
);

CREATE TABLE `Customer` (
	`customer_id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255),
	`email` VARCHAR(50) NOT NULL,
	`address` VARCHAR(500),
	PRIMARY KEY (`customer_id`)
);

CREATE TABLE `Order` (
	`order_id` INT NOT NULL AUTO_INCREMENT,
	`customer_id` INT NOT NULL,
	`order_total` FLOAT NOT NULL,
	`created_at` TIMESTAMP NOT NULL,
	PRIMARY KEY (`order_id`)
);

CREATE TABLE `Order_Line` (
	`order_line_id` INT NOT NULL AUTO_INCREMENT,
	`order_id` INT NOT NULL,
	`book_id` INT NOT NULL,
	`quantity` DECIMAL NOT NULL,
	`item_total` FLOAT NOT NULL,
	PRIMARY KEY (`order_line_id`)
);

CREATE TABLE `Author` (
	`author_id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`author_id`)
);

CREATE TABLE `Authorship` (
	`authorship_id` INT NOT NULL AUTO_INCREMENT,
	`author_id` INT NOT NULL,
	`book_id` INT NOT NULL,
	PRIMARY KEY (`authorship_id`)
);

ALTER TABLE `Inventory` ADD CONSTRAINT `Inventory_fk0` FOREIGN KEY (`book_id`) REFERENCES `Book`(`book_id`);

ALTER TABLE `Order` ADD CONSTRAINT `Order_fk0` FOREIGN KEY (`customer_id`) REFERENCES `Customer`(`customer_id`);

ALTER TABLE `Order_Line` ADD CONSTRAINT `Order_Line_fk0` FOREIGN KEY (`order_id`) REFERENCES `Order`(`order_id`);

ALTER TABLE `Order_Line` ADD CONSTRAINT `Order_Line_fk1` FOREIGN KEY (`book_id`) REFERENCES `Book`(`book_id`);

ALTER TABLE `Authorship` ADD CONSTRAINT `Authorship_fk0` FOREIGN KEY (`author_id`) REFERENCES `Author`(`author_id`);

ALTER TABLE `Authorship` ADD CONSTRAINT `Authorship_fk1` FOREIGN KEY (`book_id`) REFERENCES `Book`(`book_id`);