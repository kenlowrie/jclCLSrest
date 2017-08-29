# jclCLSrest
### Java CLS REST Command Line App

Welcome to the Java Command Line client for the CLS REST API. The CLS REST API is hosted on [http://api.cloudylogic.com](http://api.cloudylogic.com), and this sample command line application shows how you can access the API using the [Java Class Library for CLS REST](https://github.com/kenlowrie/java-clsrestapi), also available here on GitHub. If you have questions, or would like to provide feedback and/or to report a bug, feel free to contact the author, Ken Lowrie, at [www.kenlowrie.com](http://www.kenlowrie.com/).

#### Attributions

Attributions here...

<a id="install">&nbsp;</a>

### Layout of this Project

This project was built using NetBeans, and the source tree is a reflection of that. If you don't have/use NetBeans, it should be easy enough to integrate into whatever your particular Java environment happens to be (hopefully). Please review this documentation to get a better understanding of what's here, especially if you plan on using something other than NetBeans to consume it.

#### jclCLSrest Package

This package contains a command line client written in Java, that uses the [clsrestapi](https://github.com/kenlowrie/java-clsrestapi) package to access the various APIs available.

### Why a REST API for the Cloudy Logic App?

This section is probably best explained by simply reviewing the server side documentation for CLS REST. The source code and documentation for this is available in [this](https://github.com/kenlowrie/clsrestapi) GitHub repository.

#### About CLS REST and the Java Support

The [CLS REST API server side](https://github.com/kenlowrie/clsrestapi) is written in PHP, and uses [JSON](http://www.json.org/) encoding to expose the data associated with each API call. The [clsrestapi Java Package](https://github.com/kenlowrie/java-clsrestapi) contains a set of classes that expose the server APIs to Java clients. The available classes are:

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

#### Javadocs

Additional information is available in the Javadocs that can be generated from the jclCLSrest command line client. For information on how to do this, consult the NetBeans documentation.

### Summary

This concludes the summary of the Java command line client for the CLS REST API.

