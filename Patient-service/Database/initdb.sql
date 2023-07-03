# DROP DATABASE if exists mediscreenpatient;
# CREATE DATABASE if not exists mediscreenpatient DEFAULT CHARACTER SET utf8 ;
# USE mediscreenpatient;
#
DROP TABLE IF EXISTS patient;

CREATE TABLE patient
(
    patient_id BIGINT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(60) NOT NULL,
    lastname VARCHAR(60) NOT NULL,
    birthdate DATE NOT NULL,
    gender tinyint NOT NULL,
    address VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    PRIMARY KEY (patient_id)
)
ENGINE InnoDb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

LOCK TABLES patient WRITE;
INSERT INTO patient VALUES
    (1,'Lucas','Fergusson','1968-06-22','1','2 Warren Street ','387-866-1399'),
    (2,'Pippa','Rees','1952-09-27','0','745 West Valley Farms Drive','628-423-0993'),
    (3,'Edward','Arnold','1952-11-11','1','599 East Garden Ave','123-727-2779'),
    (4,'Anthony','Sharp','1946-11-26','1','894 Hall Street','451-761-8383'),
    (5,'Wendy','Ince','1958-06-29','0','4 Southampton Road','802-911-9975'),
    (6,'Tracey','Ross','1949-12-07','0','40 Sulphur Springs Dr','131-396-5049'),
    (7,'Claire','Wilson','1966-12-31','0','12 Cobblestone St','300-452-1091'),
    (8,'Max','Buckland','1945-06-24','1','193 Vale St','833-534-0864'),
    (9,'Natalie','Clark','1964-06-18','0','12 Beechwood Road','241-467-9197'),
    (10,'Piers','Bailey','1959-06-28','1','1202 Bumble Dr','747-815-0557');
UNLOCK TABLES;