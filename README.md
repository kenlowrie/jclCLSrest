# jclCLSrest
### Java CLS REST Command Line and Class Library

Welcome to the Java Command Line client and Class Library for the CLS REST API. The CLS REST API is hosted on [http://api.cloudylogic.com](http://api.cloudylogic.com), and this source code provides you with a Java interface to access that API. If you have questions, or would like to provide feedback and/or to report a bug, feel free to contact the author, Ken Lowrie, at [www.kenlowrie.com](http://www.kenlowrie.com/).

#### Attributions

Attributions here...

<a id="install">&nbsp;</a>

### Layout of this Project

This project was built using NetBeans, and the source tree is a reflection of that. If you don't have/use NetBeans, it should be easy enough to integrate into whatever your particular Java environment happens to be (hopefully). Please review this documentation to get a better understanding of what's here, especially if you plan on using something other than NetBeans to consume it.

This project consists of three primary packages:

1. clsrestapi package - this is the Java class library for the CLS REST API
2. jclCLSrest package - this is the Java command line app that provides an example of how to use the clsrestapi package
3. test/clsrestapi package - this is a set of JUNIT test classes for the clsrestapi package

#### clsrestapi Package

The clsrestapi Package provides a set of classes for Java developers to use for accessing the CLS REST API.

#### jclCLSrest Package

This package contains a command line client written in Java, that uses the clsrestapi package to access the various APIs available.

#### test/clsrestapi Package

This package contains the test classes for exercising the clsrestapi classes, ensuring that they are working properly.

### Why a REST API for the Cloudy Logic App?

This section is probably best explained by simply reviewing the server side documentation for CLS REST. The source code and documentation for this is available in [this](https://github.com/kenlowrie/clsrestapi) GitHub repository.

#### The clsrestapi Java Package

The [CLS REST API server side](https://github.com/kenlowrie/clsrestapi) is written in PHP, and uses [JSON](http://www.json.org/) encoding to expose the data associated with each API call. The clsrestapi Java Package contains a set of classes that expose the server APIs to Java clients. The available classes are:

1. [clsrestapi.Versions](#versions) - Returns the versions of a specific (or all) API. 
2. [clsrestapi.AboutUs](#about-us) - Returns a text description of what Cloudy Logic Studios does.
3. [clsrestapi.ContactInfo](#contact-info) - Returns contact information for Cloudy Logic.
4. [clsrestapi.Reels](#reels) - Returns information about demo reels including a streaming URL for each demo reel.
5. [clsrestapi.OurWork](#our-work) - Returns information about select video projects that showcase the company.

The API relies on Google's [Gson 2.8.1 library](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.1), and also relies on Java's built-in URL class. Everything thing else is built using the Java v8 built-in libraries.

#### The jclCLSrest Java Package

This package contains a command line client which exercises the various clsrestapi classes that are available. The command line version takes, optionally, two arguments:

 java -jar jclCLSrest [host | .] [api | *]
 
This first parameter is the hostname, which if not specified or written as '.', becomes http://api.cloudylogic.com.

The second parameter is the api name, which if not specified or written as '*', means ALL apis. The valid API names are:

* versions
* about-us
* contact-info
* reels
* our-work

'versions', 'reels' and 'our-work' all accept an optional parameter which is written as part of the apiname. For versions, it is one of the API names listed above. For example:

 versions/reels or versions/about-us
 
For reels and our-work, the parameter is an index into the list returned when no parameter is specified, and is zero-based. So, if you call 'reels', and it returns a count of three (3) demo reels, then you can pass 'reels/0', 'reels/1' and 'reels/2' to access each specific reel. The same applies to our-work.
 
Here are a few example fully qualified paths that would be valid:

http://api.cloudylogic.com/about-us/ - return the about-us info
http://api.cloudylogic.com/reels/ - return info on ALL demo reels
http://api.cloudylogic.com/reels/0/ - return info on the latest demo reel (0 always means latest, 1 is next latest, etc.)

#### The test/clsrestapi JUNIT test classes

These are JUNIT v4 tests integrated into the NetBeans project, and are executed like any other JUNIT test inside the NetBeans IDE. Refer to their documentation for more details on that.

#### Javadocs

Talk about the Javadocs and also the package support, and how to integrate the distribution into your project. I should also have a separate download area for the built-java packages, different versions, just mimic how others do this.

### Summary

That is a basic summary of the Java command line client and class library for the CLS REST API.

