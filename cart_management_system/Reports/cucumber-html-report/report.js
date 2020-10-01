$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/TestCase.feature");
formatter.feature({
  "name": "To Test the CartManagementSystem Application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To Test the Login Function of CartManagementSystem",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "To launch the browser and Navigate to the Url",
  "keyword": "Given "
});
formatter.match({
  "location": "com.step_defination.CartLoginSteps.to_launch_the_browser_and_Navigate_to_the_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Enter Username and Password",
  "keyword": "When "
});
formatter.match({
  "location": "com.step_defination.CartLoginSteps.to_Enter_Username_and_Password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Click the Submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.CartLoginSteps.to_Click_the_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "If Login fails give warning message",
  "keyword": "But "
});
formatter.match({
  "location": "com.step_defination.CartLoginSteps.if_Login_fails_give_warning_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Take the Screenshot and the Title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.CartLoginSteps.to_Take_the_Screenshot_and_the_Title()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To Add and Remove item",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "To Click the Add To Cart Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.CartLoginSteps.to_Click_the_Add_To_Cart_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Remove the Add From Cart",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.CartLoginSteps.to_Remove_the_Add_From_Cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.CartLoginSteps.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});