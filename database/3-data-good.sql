LOAD DATA LOCAL INFILE 'C:/Users/Alexa/Documents/GitHub/HackRegina2013/raw/doctors.csv'
 into table HACKATHON.doctors  
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

LOAD DATA LOCAL INFILE '/Users/Alexa/Documents/GitHub/HackRegina2013/raw/facilities.csv' 
into table HACKATHON.facilities
  FIELDS TERMINATED BY '\t' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;