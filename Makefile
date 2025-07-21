test:
	mvn test
skip-tests:
	mvn clean install -DskipTests
format:
	mvn spotless:apply
clean:
	mvn clean