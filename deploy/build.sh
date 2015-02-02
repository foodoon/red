cd .. && git pull
tomcat_home=/home/ec2-user/tomcat-task
mvn clean package -Dmaven.test.skip=true -Ppro
mv target/task-1.0-SNAPSHOT.war ROOT.war
rm -rf ${tomcat_home}/webapps/ROOT.war
rm -rf ${tomcat_home}/webapps/ROOT

cp ROOT.war ${tomcat_home}/webapps/

