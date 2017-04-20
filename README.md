# bouquet-java-sdk

This is a Java SDK for [OpenBouquet](https://github.com/openbouquet) API.
Please have a look to [OpenBouquet web site](https://www.openbouquet.io).

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>openbouquet</groupId>
    <artifactId>bouquet-java-sdk</artifactId>
    <version>4.2.40</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "openbouquet:bouquet-java-sdk:4.2.40"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/bouquet-java-sdk-4.2.40.jar
* target/lib/*.jar

## Getting Started

This Java SDK has been pre-generated using Swagger. The model has been cleaned & optimzed from this. It is provided as-is. 
Please follow the [installation](#installation) instruction.

BaseApi class provides different ways to authenticate to a Bouquet server. On top of that the API has been splitted in 2 children classes:
- ModelApi: Client API able to access to any object of the Bouquet model
- AnalyticsApi: Client Api able to access Bookmarks & run analyses on Bouquet server

The last important class is ClientApi in charge of running API calls & handling correctly their response

You can have a look to sample classes in package io.openbouquet.v4.test showing the different ways to authenticate.

## Documentation for Authorization

Authentication schemes defined for the API:
### kraken_auth

- **Type**: OAuth
- **Flow**: implicit
- **Authorization URL**: https://api.squidsolutions.com/staging/auth/oauth
- **Scopes**: 
  - access: Access protected resources

### basic_auth

- **Type**: HttpBasicAuth
- **Flow**: password
- **Authorization URL**: https://api.squidsolutions.com/staging/auth/oauth
- **Scopes**: 
  - access: Access protected resources

### jwt_auth

- **Type**: JWTAuth
- **Flow**: application
- **Authorization URL**: https://api.squidsolutions.com/staging/auth/oauth
- **Scopes**: 
  - access: Access protected resources

### apikey_auth

- **Type**: ApiKeyAuth
- **Flow**: application
- **Authorization URL**: https://api.squidsolutions.com/staging/auth/oauth
- **Scopes**: 
  - access: Access protected resources

These authentication are implemented in BaseAPI class & used in io.openbouquet.v4.test

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author
julien@squidsolutions.com