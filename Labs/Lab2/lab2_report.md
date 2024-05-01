# LAB2 Report

Author: Mohammed Sohail Ahmed

Date: 31-01-2024

Check [readme.txt](readme.txt) for course work statement and self-evaluation.

# T1 Java Message Service (JMS) (lab practice)

### T1.1 Hand on helloworld-jms

Complete? Yes

If Yes, insert a screen shot image to show the completion.

1. Add new user console output
   ![image caption](images/1.1-add-a-new-user.png){width=90%}
2. Add new user application-roles.properties
   ![image caption](images/1.1-add-a-new-user-1.png){width=90%}
3. Add new user application-roles.properties
   ![image caption](images/1.1-add-a-new-user-2.png){width=90%}
4. configuration-jms.cli file
   ![image caption](images/1.1-backup-copy.png){width=90%}
5. jboss-cli.bat --connect --file=configure-jms.cli command
   ![image caption](images/1.1-batch-executed-successfully.png){width=90%}
6. standalone-full.xml file
   ![image caption](images/1.1-batch-executed-successfully-1.png){width=90%}
7. mvn clean compile exec:java command
   ![image caption](images/1.1.6-mvn-clean-compile-comamnd.png){width=90%}
8. jboss-cli.bat --connect --file=remove-jms.cli command
   ![image caption](images/1.1.7-remove-a-message.png){width=90%}
9. jboss-cli.bat --connect --file=configure-jms.cli command
   ![image caption](images/1.1.7-remove-a-message-1.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T1.2 JMS message queue programming

Complete? Yes

If Yes, insert a screen shot image to show the completion.

1. JMS folder structure
   ![image caption](images/1.2.2-JSM-folder.png){width=90%}
2. mvn clean package
   ![image caption](images/1.2.3-mvn-clean-package-command.png){width=90%}
3. ECJMSProducer
   ![image caption](images/1.2.3-ECJMSProducer.png){width=90%}
4. ECJMSConsumer
   ![image caption](images/1.2-3-ECJMSConsumer.png){width=90%}
5. ECJMSProducer2
   ![image caption](images/1.2-ECJMSProducer2.png){width=90%}
6. ECJMSConsumer2
   ![image caption](images/1.2-ECJMSConsumer2.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T1.3 JMS topic programming

Complete? Yes

If Yes, insert a screen shot image to show the completion.

1. ECJMSSubscriber1
   ![image caption](images/1.2-ECJMSSubscriber1.png){width=90%}
2. ECJMSSubscriber2
   ![image caption](images/1.2-ECJMSSubscriber2.png){width=90%}
3. ECJMSPublisher
   ![image caption](images/1.2-ECJMSPublisher.png){width=90%}

If No, Add a short description to describe the issues encountered.

# T2 Message Driven Bean (MDB) (lab practice)

### T2.1 WildFly message within Eclipse

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/2.1-WildFly-message-within-Eclipse.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T2.2 Hand on helloworld-mdb project

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/2.2-HelloWorldMDBQueue.png){width=90%}
![image caption](images/2.2-HelloWorldMDBTopic.png){width=90%}
![image caption](images/2.2-helloworld-mdb-wav-file.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T2.3 ec-ejb MDB components

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/2.3-web.png){width=90%}
![image caption](images/2.3-console.png){width=90%}
![image caption](images/2.3-eclipse.png){width=90%}
![image caption](images/2.3-application-undeployed.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T2.4 JMS web clients

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/2.4-tree-structure.png){width=90%}
![image caption](images/2.4-web-message.png){width=90%}
![image caption](images/2.4-console-message.png){width=90%}
![image caption](images/2.4-web-sbjms.png){width=90%}
![image caption](images/2.4-console-sbjms.png){width=90%}
![image caption](images/2.4-web-sbjms2.png){width=90%}
![image caption](images/2.4-console-sbjms2.png){width=90%}
![image caption](images/2.4-web-index_jms.png){width=90%}
![image caption](images/2.4-web-undeployed.png){width=90%}

If No, Add a short description to describe the issues encountered.

# T3 Database Connection (lab practice)

### T3.1 H2 database

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/3.1-sql-result.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T3.2 MySQL database

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/3.2-apache-mysql.png){width=90%}
![image caption](images/3.2-phpmyadmin.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T3.3 JDBC client programming

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/3.3-DBClient-console-output.png){width=90%}
![image caption](images/3.3-console-output.png){width=90%}

If No, Add a short description to describe the issues encountered.

# T4 JPA and Hibernate (lab practice)

### T4.1 Hand on JPA example

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/4.1-jpa-example-console-output.png){width=90%}
![image caption](images/4.1-jpa-example-eclipse-output.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T4.2 Hand on ec-jpa project

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/4.2-tree-structure-console-output.png){width=90%}
![image caption](images/4.2-JPAUserTest-console-output.png){width=90%}
![image caption](images/4.2-JPAModelTest-console-output.png){width=90%}
![image caption](images/4.2-JPARemove-console-output.png){width=90%}

If No, Add a short description to describe the issues encountered.

# T5 Entity Beans (lab practice)

### T5.1 Entity Beans with embedded H2

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/5.1-greeting-message.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T5.2 Entity Beans with standalone H2

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/5.2-new-user-added.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T5.3 Entity Beans with MySQL

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/5.3-mysql-jars.png){width=90%}
![image caption](images/5.3-new-user-added.png){width=90%}
![image caption](images/5.3-use rs-table-phpmyadmin.png){width=90%}

If No, Add a short description to describe the issues encountered.

### T5.4 ec-ejb entity components

Complete? Yes

If Yes, insert a screen shot image to show the completion.

![image caption](images/5.4-EJBClient2-eclipse-output.png){width=90%}

If No, Add a short description to describe the issues encountered.

**References**

1. CP630OC lab2
2. Add your references if you used any.
