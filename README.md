# Hobby-Web-Application-Project

Coverage = 96.2%

Liverpool squad management system
The liverpool squad management system is able to track Players. Users are able to create, read, update and delete entries.

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Prerequisites
What things you need to install the software and how to install them
 
-MySQL  
-Maven  
-Java
-Eclipse

Installing
How to download the  Liverpool HWA to your computer.



Step one
git clone git@github.com:K-Edmeade/Hobby-Web-Application-Project.git

Step two
Open the file "Liverpool-HWA-1"

Step three
Open the file "index.html"

Step four 

insert your mySQL password into
spring.datasource.username=
spring.datasource.password=

in the application-prod.properties file

Step five 

create a build using "maven build ...."


Step 6
Open a terminal console and input "java -jar [new build file]"


Running the tests
When all previous steps have been followed you can run tests. To run the tests right click on the project folder QA_IMS_Project, then click Coverage As JUnit test. This will run all the tests done in the project.

Unit Tests
Unit tests are performed on the smaller units of the application such as the service class methods.

@Test
	void createUnitTest() throws Exception {
		Players entry = new Players("Kya", "edmeade", "31/03/99", 670000, "english", "position");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Players result = new Players(2L, "Kya", "edmeade", "31/03/99", 670000, "english", "position");
		String resultAsJSON = mapper.writeValueAsString(result);

		Mockito.when(this.service.create(entry)).thenReturn(result);

		mvc.perform(post("/players/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}

Integration Tests
Integration tests are tests that test multiple components of the application at the same time they are written very similarly to the unit test but they don't use mockito. This allows us to see whether the methods are interacting with each other correctly.

These integration tests were done on PlayersController

@Test
	public void createTest() throws Exception{
		Players entry = new Players("Kya", "edmeade", "31/03/99", 670000, "english", "position");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Players result = new Players(2L, "Kya", "edmeade", "31/03/99", 670000, "english", "position");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(post("/players/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}

Built With
-Git bash
-Git Hub
-Java
-Eclipse
-MySQL
-H2
-Maven
-SpringBoot
-VSC
-HTML, JS, CSS
-PostMan

Authors
Kya Edmeade
License
This project is licensed under the MIT license - see the LICENSE.md file for details

Acknowledgments
Anoush Lowton - trainer
