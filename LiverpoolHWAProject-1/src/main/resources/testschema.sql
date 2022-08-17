DROP TABLE IF EXISTS `players`;

CREATE TABLE `players`(
`id` BIGINT AUTO_INCREMENT,
`first_name` VARCHAR(255) NOT NULL,
`last_name` VARCHAR(255) NOT NULL,
`date_of_birth` VARCHAR(255) NOT NULL,
`transfer_fee` decimal(10,2) NOT NULL,
`nationality` VARCHAR(50) NOT NULL,
`position` VARCHAR(35) NOT NULL,
PRIMARY KEY (`id`)

);