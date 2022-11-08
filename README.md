# privenDemo

Framework structure:
Added dependencies to our pom file.
We created a packages to house all our different classes.
Created base class to house our repetitive methods.
We created a config file to read our browser and url details.
We created a test class to run all of our testcases.

Base Page:
	made use of FileReader to reader and load our config file.
	we used System.getproperty ("user.dir") to find the config file from users current directory.
	We made use of static WebDriver
	Added a tearDown and made use of close to close driver.

Page Objects
	create Login and Products page models to find and do operations on away from our test cases.
	These classes also extends our base class
	i primarily focused on css selection strategy and where it was not possible i used the next best locator strategy using cropath and Ranorex.
	I tried to used the dropdown locator for our sorting but this was incorrect. Thank you for the clarification Dushyant.
	
Test Cases:
	Naming convention for our test cases:
		user behaviour driven sort of syntax for anyone to be able to uderstand what each test tries to achieve.
	We extended base class to be able to use reusable methods from our base class.
	instantiated our page objects (Login and Products)
	We created variables internally for our test cases which later we would move into an excel sheet to convert our tests to data driven framework.
	We annotated all our tests with @Test which we get from TestNG.	
	
With this implementation i can improve the frame work to be data driven and also include further logic on the sorting to be able to sort from lowest price.
I can externalize our expected values from our test cases without hard coding them as i have now down.