DROP SCHEMA HACKATHON;
CREATE SCHEMA HACKATHON;
CREATE TABLE HACKATHON.facilities(
	rha				int,
	rha_name		varchar(30),
	facility_id		varchar(15),
	facility_name	varchar(65),
	facility_type	varchar(40),
	type_id			int,
	hospital_designation varchar(40),
	street_address	varchar(35),
	location		varchar(25),
	postal_code		varchar(7),
	lat_dd			float(13, 9),
	long_dd			float(13, 9),
	PRIMARY KEY(facility_name)
);
CREATE TABLE HACKATHON.doctors(
	provider_id			int,
	group_number		varchar(15),
	num_phys_in_group	int,
	clinic_name			varchar(40),
	community			varchar(25),
	postal_code			varchar(7),
	doctor_name			varchar(35),
	specialty			varchar(55),
	rha_name			varchar(30)
);




