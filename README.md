# To-do List Application
<p>The application comprises of 2 seperated applications.<br/> <br/>
Back-end application uses the following: Spring Boot, Spring Data, MVC, Lombok, H2, JDBC driver and Maven as the package manager.<br/> <br/>

Front-end application is a React.js app. It makes use of many libraries such as bootstrap and jquery. Yarn is the package manager for the front-end.<br/> <br/>

The front-end and back-end applications are connected to each other with REST APIs.<br/><br/>

Please note that I've started to learn about how to use these technologies exactly one week ago. So this project is a combination of the tutorials and projects I found online.</p>

<h1>Windows</h1>
<h2 style="text-decoration: underline">Deploying the back-end</h2>
<h3>1. Install git on your computer</h3>
<p> Download and install git from the following <a href="https://git-scm.com/download/win" >link</a>.<br/>
You can either clone the repository or download the project manually. </p>

<h3>2. Install JDK 1.8 </h3>
<p> Download and install jdk8u-181 from the following 
<a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html" >link</a>.</p>

<h3>3. Install Maven </h3>
<p> Download maven from the following <a href="https://maven.apache.org/download.cgi" >link</a>. If you're not sure how to install, you can follow this <a href="https://www.mkyong.com/maven/how-to-install-maven-in-windows/">guide</a>.</p>

<h3>4. Run the application </h3>
<p> Head into the root of the Todos-Server project from the file explorer. Right click and launch git bash inside. Then enter the following command:<br/><br/>
<code>$ mvn clean spring-boot:run</code><br/><br/>
Please note that Maven will be making a lot of downloads, so you may need to wait a while depending on your internet connection.
</p>

<h3>5. Check your browser (or use Curl if it's installed) </h3>
<p> Once the application is launched, open your browser and go to the following link:<br/><br/>
<a href="#" >localhost:8080</a> or <a href="#" >localhost:8080/lists</a> (localhost:8080 is the default address. It has been tested on 3 different OSs.)
<br/><br/>
You should see the following message: &nbsp; Congratulations from TodosController.java<br/><br/>  &nbsp; &nbsp; or the template DB entries depending on the address you entered to your browser.
</p>

<h2 style="text-decoration: underline">Deploying the front-end</h2>

<h3>6. Install Yarn </h3>
<p> Download (.msi) and install Yarn from the following 
<a href="https://yarnpkg.com/lang/en/docs/install/#windows-stable">link</a>.</p> 

<h3>7. Install Node.js </h3>
<p> Download (.msi) and install Node.js from the following <a href="https://nodejs.org/en/download/">link</a>.</p> Once Node.js is installed, repeat the steps provided in the <a href="https://www.mkyong.com/maven/how-to-install-maven-in-windows/">guide</a> given in step 3 for changing Windows system variables. Edit your PATH environment variable by adding <code>%AppData%\npm\bin</code> before the Node.js entry. Move it if it already exists.<br/> This is necessary to run <code>$ npm</code> commands in git bash.

<h3>8. Install React.js </h3>
<p> Then enter the following command in git bash:<br/><br/>
<code>$ npm install -g create-react-app</code><br/><br/>
There will be a brief download.

<h3>9. Download the necessary node modules </h3>
<p> Head into the root of the todos-client project from the file explorer. Right click and launch git bash inside. Then enter the following command:<br/><br/>
<code>$ npm install</code><br/><br/>
Please note that Maven will be making a lot of downloads, so you may need to wait a while depending on your internet connection.
</p>

<h3>10. Run the application </h3>
<p> Head into the root of the todos-client project from the file explorer. Right click and launch git bash inside. Then enter the following command:<br/><br/>
<code>$ yarn start</code><br/><br/>
Your OS will open the front-end page in your default browser.<br/> If you see no To do lists, check the address in the browser. If it's different than <a href="#" >localhost:3000</a> then you need to open TodoListController.java in the directory<br/> ./Todos-Server/src/main/java/com/cagdasmer/springrest/todolist and change the line: <br/><br/><code>@CrossOrigin(origins = "http://localhost:3000")</code> according to the port allocated to the application.
</p>

<h1>Linux (Ubuntu 18.04)</h1>
<p> Enter the following commands in Linux terminal in the order they are given. </p>
<h2 style="text-decoration: underline">Deploying the back-end </h2>
<code>1. $ sudo apt install git</code><br/><br/>
<p> You can either clone the repository or download the project manually. </br> 
If jdk 1.8 is not installed in your system. Once the project is cloned/downloaded, open the pom.xml in Todos-Server directory and remove the comment tags around the last dependency property. </p>

<code>2. $ sudo apt install maven</code><br/><br/>
<code>4. $ mvn clean spring-boot:run</code> <br/><br/>
<h2 style="text-decoration: underline">Deploying the back-end</h2>
<p> Open a new terminal </p>
<code>3. $ sudo apt install curl</code><br/><br/>
<code>4. $ curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
$ echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list</code><br/><br/>
<code>5. $ sudo apt-get update && sudo apt-get install yarn</code><br/><br/>
<code>6. $ yarn install</code><br/><br/>
<code>7. $ sudo apt install npm</code><br/><br/>
<code>8. $ npm install -g create-react-app</code><br/><br/>
<code>9. $ npm install (inside todos-client)</code><br/><br/>
<code>10. $ yarn start</code><br/><br/>

<h2 style="text-decoration: underline">Known Issues</h2>
<p>1. Once all the items are deleted from a list, newly added items do not show up until the page is refreshed. 
I'm not yet aware of the exact reason of this issue.</p>
<p>2. Once a new to-do list is created, the completion filters will not work on newly added items until the checkboxes are ticked once.<br />
This is because the newly added items' initial values are null/undefined and they are treated as uncontrolled components. 
I aim to fix this issue in the future.</p>
<p>3. Sometimes searcing in a newly created and empty list may result in errors, making it impossible to return to the page. 
It is possible to recover from this problem by re-deploying the server-side application.<p/>
