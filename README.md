spring-ejb3-webapp
=============

This application demonstrates the interoperability between spring mvc and ejb3 SLSB layer.

To build and run the application follow this install instructions:

1. Download and unzip jboss-as-7.1.1.zip.
2. Clone this repository
3. You need java 1.6 and maven3 to build the application
4. Start jboss with standalone.sh or standalone.bat
5. To build and deploy call mvn clean package jboss-as:deploy

To redeploy call mvn clean package jboss-as:redpeloy