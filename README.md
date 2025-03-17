![Java version](https://img.shields.io/badge/Java-17-red) ![Version](https://img.shields.io/badge/Version-1.3.0-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.3-green)

# Java Spring Boot +  ButterCMS Starter Project

This Java + Spring Boot starter project fully integrates with dynamic sample 
content from your ButterCMS account, including main menu, pages, blog posts, 
categories, and tags, all with a beautiful, custom theme with already-implemented 
search functionality. All of the included sample content is automatically created 
in your account dashboard when you sign up for a free trial of ButterCMS.

[View our live demo hosted at Heroku](https://java-starter-buttercms.herokuapp.com/), or you can click a button below
to deploy your own copy of our starter project to the provider of your  choice.

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/ButterCMS/java-starter-buttercms&env%5BJAVA_BUTTER_CMS_API_KEY%5D=check%20https://buttercms.com/settings)


## 1. Installation

### Prerequisites

This project requires Java 17 and Maven. All other dependencies (Spring Boot, Java SDK for ButterCMS) are automatically managed by Maven.

#### Installing Java 17 and Maven on Ubuntu
```bash
# Update package list and install OpenJDK 17
sudo apt update && sudo apt install openjdk-17-jdk
# Install Maven
sudo apt install maven
```

#### Installing Java 17 and Maven on macOS
```bash
# Using Homebrew
brew tap homebrew/cask-versions
brew install --cask temurin17
# Using Homebrew
brew install maven
```

To get started, clone and cd into the repo.

```bash
git clone https://github.com/ButterCMS/java-starter-buttercms.git
cd java-starter-buttercms
```

### 2. Set API Token

To fetch your ButterCMS content, add your API token as an environment variable.

```bash
$ echo 'JAVA_BUTTER_CMS_API_KEY=<Your API Token>' >> .env`
```

### 3. Build the project

Build the project with the following command

```bash
$ mvn install
```

### 4. Run the project

To view the app in the browser, you'll need to run the local development server:

```bash
$ mvn spring-boot:run
```
Alternatively, you can run it directly via the `java` command

```bash
$ java -jar target/spring-starter-buttercms-*.jar
```

where the file name `spring-starter-buttercms` will be appended by the value of the version tag `<version>` in [pom.xml](pom.xml)

Congratulations! Your starter project is now live. To view your project, 
point your browser to [http://localhost:8080](http://localhost:8080).

## 5. Deploy on Heroku

Deploy your Spring Boot app using Heroku. With a single click, you'll create a 
copy of our starter project in your Git provider account, instantly deploy it, 
and institute a full content workflow connected to your ButterCMS account. Smooth.

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/ButterCMS/java-starter-buttercms&env%5BJAVA_BUTTER_CMS_API_KEY%5D=check%20https://buttercms.com/settings)


### 6. Previewing Draft Changes

By default, your starter project is set up to allow previewing of draft changes 
saved in your ButterCMS.com account. To disable this functionality, set the 
following value in your .env file: `JAVA_BUTTER_CMS_PREVIEW=false`
