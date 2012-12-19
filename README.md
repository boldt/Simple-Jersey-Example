## Example project

This project uses

* [Maven] (http://maven.apache.org/)
* [Netty] (http://netty.io/)
* [Grizzly] (http://grizzly.java.net/)
* [Jersey] (http://jersey.java.net/)
* [JAXB (Java Architecture for XML Binding)](http://www.oracle.com/technetwork/articles/javase/index-140168.html)
* [JSON] (http://www.ietf.org/rfc/rfc4627.txt)

## Howto

### Get the sources

`git clone git@github.com:boldt/Simple-Jersey-Example.git`

#### Eclipse

Import as Maven project with [Maven Integration (m2e)](http://eclipse.org/m2e/).


Run the `Main`:

* The first argument defines the Server. It can be `grizzly` or `netty`.
* The second argument is the port, which is 9999 by default.

#### One-jar standalone

Go to the project folder and run `mvn clean package`.
The file `target/Simple-Jersey-Example-1.0.jar` will be created

Run as Netty server on port 5000:

  * `java -jar target/Simple-Jersey-Example-1.0.jar netty 5000`

Run as Grizzly server on port 5000:

  * `java -jar target/Simple-Jersey-Example-1.0.jar grizzly 5000`

### Test:

  * `curl -X GET curl -X GET http://localhost:5000/users/xml`

The result

	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<users>
		<user>
			<userId>100</userId>
			<username>test</username>
		</user>
	</users>


  * `curl -X GET curl -X GET http://localhost:5000/users/json`

The result


	[{"username":"test","userId":100}]


### Thanks to

* [Gabriel Ciuloaica](https://github.com/devsprint) for the [jersey-netty-container] (https://github.com/devsprint/jersey-netty-container)

### References

* http://stackoverflow.com/questions/13842377
