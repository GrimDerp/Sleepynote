// do stuff
//$ mkdir greeting-library

// in: greeting-library/build.gradle

plugins {
    id 'groovy'
}

dependencies {
    compile 'org.codehaus.groovy:groovy:2.4.10'

    testCompile 'org.spockframework:spock-core:1.0-groovy-2.4', {
        exclude module: 'groovy-all'
    }
}
//
/** then update: settings.gradle:
**/
include 'greeting-library'
/** then: 
$ mkdir -p src/main/groovy/greeter
$ mkdir -p src/test/groovy/greeter 
**/
 /** then:
 Add a GreetingFormatter class to the greeter package in src/main/groovy:
**/
greeting-library/src/main/groovy/greeter/GreetingFormatter.groovy
package greeter

import groovy.transform.CompileStatic

@CompileStatic
class GreetingFormatter {
    static String greeting(final String name) {
        "Hello, ${name.capitalize()}"
    }
}
/**

**/

