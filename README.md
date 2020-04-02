Student Service - multi-module JavaEE Project
==============================================================================================
Author: Oskar Pawica  
Technologies: Java8, Maven, Wildfly, Java EE, JAX-WS  
Project for "Service Oriented Architecture" AGH course  
What is it?
-----------

Web Service SOAP Project containing both EJB module with API implementation and SOAP Connectors.  
The web service includes e.g. methods with proper XML classes wrapping and Base64 file encoding.  

System requirements
-------------------

All you need to build this project is Java 8.0 (Java SDK 1.8) or better, Maven 3.1 or better.

The application this project produces is designed to be run on JBoss WildFly.


Start JBoss WildFly with the Web Profile
-------------------------

1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat

 
Build and Deploy the Quickstart
-------------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean package wildfly:deploy

4. This will deploy `target/projekt.ear` to the running instance of the server.


Access the application 
---------------------

The WSDL file of the application will be available at the following URL: <http://localhost:8080/soa/StudentService?wsdl>.

1. Run SoapUI.
2. Create a new project and paste the URL of the WSDL file in the configuration
3. Methods should be listed on the left sidebar of SoapUI
4. Try adding students, updating them, listing their courses etc.  
  
  _Using methods requires authentication. Data of the users is available in the domain's .properties files.)


Debug the Application
---------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc
