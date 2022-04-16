# Basic structure of my Java application
The basic structure depends on the Gradle Wrapper.

## Git Submodule
After cloning this project, check out submodules.  
`git submodule init && git submodule update`

## The Gradle Wrapper
### Upgrading the Gradle Wrapper  
<https://docs.gradle.org/current/userguide/gradle_wrapper.html#sec:upgrading_wrapper>  
`gradlew wrapper --gradle-version X.X && ./gradlew wrapper`

## Package
    com/github/arknote02/[domain]/        # base package
        Application.java                  # boot class
        domain/
            model/
            service/
            port/
        adapter/
            [resource]/
                model/
                [Resource]Adapter.java
