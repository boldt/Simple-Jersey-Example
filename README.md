This project combines

* [Netty] (http://netty.io/)
* [Jersey] (http://jersey.java.net/)
* [JAXB (Java Architecture for XML Binding)](http://www.oracle.com/technetwork/articles/javase/index-140168.html)
* [JSON] (http://www.ietf.org/rfc/rfc4627.txt)

### How to

Import as Maven project in Eclipse. Run the `JaxrsServer`. The first argument defines the port, which is 9999 by default.

Open:
* http://localhost:9999/users/1
  * An empty list: `[]`
* http://localhost:9999/users/2
  * A list with an user: `[{"userId":100,"username":"test"}]`

### Thanks to

* [Gabriel Ciuloaica] (https://github.com/devsprint/jersey-netty-container)
