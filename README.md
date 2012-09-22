wro4j-extension-less-java5
==========================

wro4j-extensions module, forked from the original wro4j-extensions module of the great [WRO4J](https://github.com/alexo/wro4j) project (version 1.4.9 - last java5 compliant version) to compile on java 5 (yes, sometimes we're stuck with it...)
All the java-6 restrictive modules have been removed, and the code adapted to compile on JDK5.

### So, What remains ? 

Well, kinda lot of stuff, I was surprised :

##### Css processors :
-   Less

##### Js processors :
-   BeautifyJs
-   CoffeeScript
-   DustJS
-   Handlebars
-   Hogan
-   JsHint
-   JsLint
-   UglifyJs

Note that I only used the less processors, I didnt tests the other ones, but tests does pass, and there should be no reason for them not to work, due to the fact they are all based on Rhino.

### How to use

I've deployed the artefact on my personnal repository. See [There](https://github.com/wayofspark/maven-repository)

Hope that will helps guy who are stuck on java5 on some projects, but who still want to use some of the great wro4j extensions !

Feel free to feedback.