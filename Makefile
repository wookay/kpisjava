run:
	java  -cp `find * -name "*.jar" | tr "\n" ":"` webservice/MedicinesInfoWS/ClientTest

build:
	javac -cp `find * -name "*.jar" | tr "\n" ":"` -Xlint:unchecked -d . src/*.java

clean:
	rm -rf webservice
