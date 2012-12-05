This project combines

* [Netty] (http://netty.io/)
* [Grizzly] (http://grizzly.java.net/)
* [Jersey] (http://jersey.java.net/)
* [JAXB (Java Architecture for XML Binding)](http://www.oracle.com/technetwork/articles/javase/index-140168.html)
* [JSON] (http://www.ietf.org/rfc/rfc4627.txt)

### How to

Import as Maven project in Eclipse. 

Run the `JaxrsServer`:

* The first argument defines the Server. It can be `grizzly` or `netty`.
* The second argument is the port, which is 9999 by default.

Afterwards, open a resource:

* [http://localhost:9999/users/1] (http://localhost:9999/users/1)
  * Should return an empty list: `[]`
* [http://localhost:9999/users/2] (http://localhost:9999/users/2)
  * Should return a list with an user: `[{"userId":100,"username":"test"}]`

### Known bugs

`mvn package` produces a package with dependencies under `target`: `Jersey-Netty-Container-Example-0.0.1-SNAPSHOT.jar`

Run as Netty server:

* `java -jar target/Jersey-Netty-Container-Example-0.0.1-SNAPSHOT-jar-with-dependencies.jar netty 5000`

Run as Grizzly server:

* `java -jar target/Jersey-Netty-Container-Example-0.0.1-SNAPSHOT-jar-with-dependencies.jar grizzly 5000`

Calling a ressource on the jar results in the following exception:

```
Caused by: com.sun.jersey.api.MessageException: A message body writer for Java class java.util.ArrayList, and Java type java.util.List<de.dennis_boldt.User>, and MIME media type application/json was not found
```
### Thanks to

* [Gabriel Ciuloaica] (https://github.com/devsprint/jersey-netty-container)
