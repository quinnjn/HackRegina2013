
#PREP DATABASE
cat database/*.sql | mysql -u root --password=hackathonfall2013

#INSTALL CAKE
cp -r cake/* /var/www/
chmod -R 777 /var/www/app


