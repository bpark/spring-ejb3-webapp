spring-ejb3-webapp
=============

This application demonstrates the interoperability between spring mvc and ejb3 SLSB layer.

The application is a sample blog webapp styled with twitter bootstrap v2.0.

To build and run the application follow this install instructions:

1. Download and unzip jboss-as-7.1.1.zip.
2. Clone this repository
3. You need java 6 and maven 3 to build the application
4. Start the jboss application server with standalone.sh or standalone.bat
5. To build and deploy call mvn clean package jboss-as:deploy (make sure, that jboss is running)

To redeploy call mvn clean package jboss-as:redpeloy
To undeploy the application call jboss-as:undeploy