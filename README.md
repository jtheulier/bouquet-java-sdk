# bouquet-java-sdk

This is a Java SDK for [Bouquet API](https://github.com/bouquet).
Please have a look to [Bouquet web site](https://www.bouquet.io).

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
    <groupId>bouquet</groupId>
    <artifactId>bouquet-java-sdk</artifactId>
    <version>4.2.40</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "bouquet:bouquet-java-sdk:4.2.40"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/bouquet-java-sdk-4.2.40.jar
* target/lib/*.jar

## Getting Started

This Java SDK has been pre-generated using Swagger. The model has been cleaned & optimized from this. It is provided as-is. 
Please follow the [installation](#installation) instruction.

BaseApi class provides different ways to authenticate to a Bouquet server. On top of that, the SDK has been splitted in 2 children classes:
- ModelApi: SDK API able to access to any object of the Bouquet model
- AnalyticsApi: SDK Api able to access Bookmarks & run analyses on Bouquet server

The last important class is ClientApi in charge of running API calls & handling correctly their response

You can have a look to sample classes in package io.bouquet.v4.test showing the different ways to authenticate & run basic calls.

## Documentation for Authorization

Authentication schemes defined for the API:
### kraken_auth

- **Type**: OAuth
- **Flow**: implicit
- **Scopes**: 
  - access: Access protected resources

### basic_auth

- **Type**: HttpBasicAuth
- **Flow**: password
- **Authorization URL**: https://api.squidsolutions.com/staging/v4.2/auth-token
- **Scopes**: 
  - access: Get a Oauth token

### jwt_auth

- **Type**: JWTAuth
- **Flow**: application
- **Authorization URL**: https://api.squidsolutions.com/staging/v4.2/token
- **Scopes**: 
  - access: Get a Oauth token for a Client (any user can be used to get a Oauth token from)

### api_key_auth

- **Type**: ApiKeyAuth
- **Flow**: application
- **Authorization URL**: https://api.squidsolutions.com/staging/v4.2/token
- **Scopes**: 
  - access: Get a Oauth token for a specific user

These authentication are implemented in BaseAPI class & used in io.bouquet.v4.test

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author
julien@squidsolutions.com