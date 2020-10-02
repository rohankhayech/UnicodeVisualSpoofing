all: build

build:
	javac --module-path javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml src/controller/*.java src/view/*.java src/model/*.java


run:
	java --module-path javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml src/controller/Main

clean:
	rm src/controller/*.class src/view/*.class src/model/*.class test/*.class
