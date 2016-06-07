# HibernateInheritanceTablePerHerarchy
Using Annotation

One Table Per Class Hierarchy example
--------------------------------------

						              Employee
							                ^
							                |
					----------------------------------------------
					|					                         |
		RegularEmployee		                      ContractEmployee


In One Table per Class Hierarchy scheme, we store all the class hierarchy in a single SQL table. 
A <b>discriminator</b> is a key to uniquely identify the base type of the class hierarchy.

Following are the advantages and disadvantages of One Table per Class Hierarchy scheme:

Advantage
---------

This hierarchy offers the best performance even for in the deep hierarchy since single select may suffice.

Disadvantage
------------

Changes to members of the hierarchy require column to be altered, added or removed from the table.

RDBMS (MySQL) Table Script:
---------------------------
#Employee_Details
CREATE TABLE `employee_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `disc_type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salary` float,
  `bonus` float,
  `pay_per_hour` float,
  `contract_duration` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

Logger:Query executed behind the process:
------------------------------------------
Hibernate: insert into employee_details (name, bonus, salary, disc_type) values (?, ?, ?, 'Regular')

Hibernate: insert into employee_details (name, contract_duration, pay_per_hour, disc_type) values (?, ?, ?, 'Contract')

