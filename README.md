# OrderProject
Pizza order project
README.doc
Assumptions: 
1. Assuming that the sample_data file is sanitized i.e. order and time in the file is separate by \t\t.
2.Ordering based on time of the order received and if that is same then based on the order name.
3. Repository layer will be used in future when the data needs to be saved in the DB.
4. Dto layer will be used in future to render the Dto on the UI.
Run the test from command line:
1. Go to the root directory of the project and run mvn test. 
To create the jar, go to the root directory and run mvn package. Jar would be created in the target folder. Run the executable jar
1. Go to order-project-1.0-SNAPSHOT in the target folder from command prompt.
2. Run java -jar order-project-1.0-SNAPSHOT.jar C:\Users\Bhavna\Desktop\JavaChallenge\sample_data.txt C:\Users\Bhavna\Desktop\JavaChallenge\output.txt
NOTE: Please specify the path of sample_data and output from your machine.

Design Decision:
1. Designed the application based on Spring MVC pattern.
2. Since currently the project doesn't have a REST endpoint hence controller has Main.java.
3. Model layer had Order entity which eventually can be saved in the DB.
4. View folder is empty for now but if there was a UI then that would go under the view folder. Currently the output is saved in output.txt passed as parameters.
5. Service layer has a PizzaOrderinterface that has the methods: readInputFile(), arrangeInOrder(), writeOutputFile(). These methods are implemented in PizzaOrderImplementaion.
6. Repository layer is used to save the Order entity in the DB in future and return List<OrderDto> to be rendered on the UI.
7. PizzaOrderImplTest has the test for arrangeInOrder method to make sure the ordering is getting performed correctly.
