DROP SCHEMA IF EXISTS HACKATHON;
CREATE SCHEMA HACKATHON;
CREATE TABLE HACKATHON.Facilities(
	table_id 		int NOT NULL,
	rha				int,
	rha_name		varchar(30),
	facility_id		varchar(15),
	facility_name	varchar(65),
	facility_type	varchar(40),
	type_id			int,
	hospital_designation varchar(40),
	street_address	varchar(35),
	location		varchar(20),
	postal_code		varchar(7),
	lat_dd			float(10, 7),
	long_dd			float(10, 7),
	PRIMARY KEY(table_id)
)



