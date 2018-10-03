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
/** then:
Add a Spock Framework test called GreetingFormatterSpec in the greeter package under src/test/groovy.
**/
greeting-library/src/test/groovy/greeter/GreetingFormatterSpec.groovy
package greeter

import spock.lang.Specification

class GreetingFormatterSpec extends Specification {

    def 'Creating a greeting'() {

        expect: 'The greeting to be correctly capitalized'
        GreetingFormatter.greeting('gradlephant') == 'Hello, Gradlephant'

    }
}
/** then:
Run ./gradlew build from the top-level project directory.

$ ./gradlew build
**/
> Task :greeting-library:compileJava NO-SOURCE

> Task :greeting-library:compileGroovy
Picked up _JAVA_OPTIONS: -Xmx2048m -Xms512m

> Task :greeting-library:processResources NO-SOURCE
> Task :greeting-library:classes
> Task :greeting-library:jar
> Task :greeting-library:assemble
> Task :greeting-library:compileTestJava NO-SOURCE
> Task :greeting-library:compileTestGroovy
> Task :greeting-library:processTestResources NO-SOURCE
> Task :greeting-library:testClasses

> Task :greeting-library:test
Picked up _JAVA_OPTIONS: -Xmx2048m -Xms512m

> Task :greeting-library:check
> Task :greeting-library:build
/** should produce:
BUILD SUCCESSFUL in ~20s
4 actionable tasks: 4 executed
**/

