cd .. && git pull
tomcat_home=/dev_data/server/tomcat-red
mvn clean package -Dmaven.test.skip=true -Ppro
mv target/red-1.0-SNAPSHOT.war ROOT.war
rm -rf ${tomcat_home}/webapps/ROOT.war
rm -rf ${tomcat_home}/webapps/ROOT

cp ROOT.war ${tomcat_home}/webapps/

