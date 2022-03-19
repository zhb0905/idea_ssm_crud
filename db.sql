CREATE SCHEMA `ssm_crud` DEFAULT CHARACTER SET utf8 ;

use ssm_crud;

CREATE TABLE `tbl_dept` (
                            `dept_id` int NOT NULL AUTO_INCREMENT,
                            `dept_name` varchar(45) NOT NULL,
                            PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `tbl_emp` (
                           `emp_id` int NOT NULL AUTO_INCREMENT,
                           `emp_name` varchar(45) NOT NULL,
                           `gender` char(1) DEFAULT NULL,
                           `email` varchar(45) DEFAULT NULL,
                           `d_id` int DEFAULT NULL,
                           PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;