# serverclient

default port: 8083

To change port navigate to resources/application.properties
Change the server.port value.

The following project is a smartEquipExercise application implemented using spring boot and H2 Database.
It is built using Spring MVC architecture

The following are the clasess implemented <br />


1. MessageController Class -  Which accepts the incoming requests from client to the server<br />

   i. randomNumberForQuestion Method - When the client requests a question it redirects the request service class and get a question to send it to the client<br />
   ii. answersForQuestion Method - When the client responds with an answer for the question it redirects to service class for checking the answer<br />

2. SmartEquipMessagingService class - Which accepts the incoming requests from controller class and responds to them <br/>

   i. questionsWithRandomNumber - It generates a random two or three variable question </br>
   ii. checkAnswersForQuestion - It receives the client response to the question and calculates the corresponding questions answer</br>
   a. if the answer is wrong then the client returns is wrong and sends bad response with 200 status</br>
   b. if the answer is correct then the client returns is OK and sends 200 response to the client</br>

3. QuestionModel class -  It is with lombok annotation @AllArgsConstructor,   @Getter </br>

4. LoggerAspectJ class - Implemented "Log" statements in controller and service classes with  @Aspect, @Component</br>

#Incomplete Status Details </br>
1. Implementation of independent state of the previous request. (This can be implemented through maintaining security and JWT token)</br>
2. Junit test class</br>
3. Windows batch script to start the server.</br>



