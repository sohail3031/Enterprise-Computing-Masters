# stats-mvn

stats-mvn is a Java project that implements and tests the Statistics interface, which defines methods for performing simple descriptive statistics operations on a collection of data values. It uses Maven to manage the build, dependency, and documentation of the project.

# Installation

To install the project, follow these steps:

1. Clone the project repository from GitHub using the command:
   git clone https://github.com/your-username/stats-mvn.git

2. Change the directory to the project root using the command:
   cd stats-mvn

3. Install the project dependencies using the command:
   mvn install

# Editing the source code

The source code of the project is located in the src/main/java directory. The project consists of two Java classes:

Statistics.java: an interface that defines methods for performing simple descriptive statistics operations on a collection of data values.
ECStatistics.java: a class that implements the Statistics interface and provides the implementation details for the interface methods.
To edit the source code, you can use any IDE or text editor that supports Java and Maven. For example, you can use VSCode, Eclipse, or IntelliJ IDEA.

# Building the project

To build the project, follow these steps:

1. Change the directory to the project root using the command:
   cd stats-mvn

2. Compile the project using the command:
   mvn compile

3. Package the project into a jar file using the command:
   mvn package

The jar file will be created in the target directory with the name stats-mvn-1.0-SNAPSHOT.jar.

# Testing the project

To test the project, follow these steps:

1. Change the directory to the project root using the command:
   cd stats-mvn

2. Run the JUnit test class using the command:
   mvn test

The test class is located in the src/test/java directory with the name StatisticsTest.java. It contains two test methods that test the addData and stats methods of the Statistics interface.

# Executing the project

To execute the project, follow these steps:

1. Change the directory to the project root using the command:
   cd stats-mvn

2. Run the main class using the command:
   java -jar target/stats-mvn-1.0-SNAPSHOT.jar

The main class is located in the src/main/java directory with the name MyStatistics.java. It creates an ECStatistics object and adds data values from 1 to 10000, invokes the Statistics methods, and prints the results to the console.
