# KamonRouterTests
Tests to play around with Kamon router metrics

To report to kamino create a kamino.conf in src/main/resources and add the kamino.api-key

To run it with maven:

```
export MAVEN_OPTS="-javaagent:path-to-aspectjweaver.jar"

mvn exec:java
```