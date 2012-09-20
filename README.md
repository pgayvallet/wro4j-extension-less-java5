wro4j-extension-less-java5
==========================

wro4j-extensions module, forked from the original wro4j-extensions project (version 1.4.9 - last java5 compliant version) to compile on java 5 (yes, sometimes we're stuck with it...)
All the java-6 restrictive modules have been removed, and the code adapted to compile on JDK5.

So, What remains ? Well, kinda lot of stuff, I was surprised :

Css processors :
    - Less

Js processors :
    - BeautifyJs
    - CoffeeScript
    - DustJS
    - Handlebars
    - Hogan
    - JsHint
    - JsLint
    - UglifyJs

Note that I only used the less processors, I didnt tests the other ones, but tests does pass, and there should be no reason for them not to work, due to the fact they are all based on Rhino.

Hope that will helps.
