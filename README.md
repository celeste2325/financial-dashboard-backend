# financial-dashboard-backend

These are the files used to develop the financial dashboard. The aim of this dashboard is to provide a simple display of account balances.
The technology stack used include
[Java 17](https://community.chocolatey.org/packages/openjdk/17.0.2), and Lombok.

## Project Information

This project does not utilize a traditional database. Instead, it manages data through a JSON file.

### Data Structure

- JSON File Path:  `src/main/java/happy/hive/community/financial/balances.json`

### Example JSON Structure

Here is an example of the structure of the JSON file:

```
{
  "accounts": [
    {
      "accountName": "Aeroplane Visa Infinite",
      "accountID": "5023 5678 8746 8723",
      "balance": "400",
      "currency": "CAD",
      "type": "Credit"
    },
    {
      "accountName": "Everyday Chequing",
      "accountID": "1002 3345 1234 5678",
      "balance": "2500",
      "currency": "CAD",
      "type": "Balance"
    },
]
}
```

### Lombok Configuration

This project uses **Lombok** for reducing boilerplate code (e.g., getters, setters, constructors, etc.). Lombok is
already configured in the `pom.xml` with the following dependency:

```xml

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.20</version>
    <scope>provided</scope>
</dependency>
```

Lombok Installation in Your IDE
To ensure Lombok works correctly in your local development environment, you need to install and configure Lombok for
your IDE. Follow the steps below:

<u>For IntelliJ IDEA:</u>

1) Go to File -> Settings -> Plugins.
2) Search for Lombok and click Install.
3) After installation, enable annotation processing:
   Navigate to File -> Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors, and check Enable
   annotation processing.

<u>For Eclipse:</u>

1) Download the Lombok JAR from the official site.
2) Run the JAR by executing

```
java -jar lombok.jar
```

3) The Lombok installer will open; select your Eclipse IDE installation folder and proceed with the installation.
4) Restart Eclipse and ensure annotation processing is enabled by going to:
   Preferences -> Maven -> Annotation Processing -> Enable.

   ## License

[MIT](https://choosealicense.com/licenses/mit/)
