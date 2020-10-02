SDK_PATH = javafx-sdk-11.0.2/lib
MODULES = javafx.controls,javafx.fxml
SRC = src/controller/*.java src/view/*.java src/model/*.java test/*.java

build:
	javac --module-path $(SDK_PATH) --add-modules $(MODULES) $(SRC)

run: build
	java --module-path $(SDK_PATH) --add-modules $(MODULES) src/controller/Main

test: build
	java test/UnitTestApp

test-patch: build
	java test/UnitTestConversion

clean:
	rm src/controller/*.class src/view/*.class src/model/*.class test/*.class
 