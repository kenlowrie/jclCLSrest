# jclCLSrest
### Java Command Line CLS REST API client

Welcome to the Java Command Line client for the CLS REST API, hosted on [http://api.cloudylogic.com](http://api.cloudylogic.com). The information here should help you understand the Java Classes I have put together for accessing CLS Rest. If you have questions, or would like to provide feedback and/or to report a bug, feel free to contact the author, Ken Lowrie, at [www.kenlowrie.com](http://www.kenlowrie.com/).

#### Attributions

Attributions here...

<a id="install">&nbsp;</a>

### Layout of the package

NetBeans project

The CLSRESTAPI package.

The jclCLSrest package.

The JUNIT test classes.

### Why a REST API for the Cloudy Logic App?

Just link back to the server side project and docs for this...

#### The CLSRESTAPI Java Package

The CLS REST API server side is written entire in PHP, and uses [JSON](http://www.json.org/) encoding to expose the data associated with each API call. The APIs available are:

1. [versions](#versions) - Returns the versions of a specific (or all) API. 
2. [about-us](#about-us) - Returns a text description of what Cloudy Logic Studios does.
3. [contact-info](#contact-info) - Returns contact information for Cloudy Logic.
4. [reels](#reels) - Returns information about demo reels including a streaming URL.
5. [our-work](#our-work) - Returns information about select video projects that showcase the company.

The API is designed to be called as a standard HTTP GET request. On my server, I created a subdomain, called [api.cloudylogic.com](http://api.cloudylogic.com). That subdomain has a document root of /api in my web servers data directory. Not that any of that matters per se, but in the interest of explaining how I set things up, it's here.
