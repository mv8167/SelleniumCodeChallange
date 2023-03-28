# SelleniumCodeChallenge
test code for NexTraq

The GitHubLoginTest, is working

The GitHubTokenGeneration, I had issues finding how to get locatpors for the top-right Head(dropdown)->Settings, and seleectin selrctiong the Generate new token (dropdown)

Xpath

*Developer Settings, link
//span[normalize-space()='Developer settings']

Personal access tokens, link
//span[normalize-space()='Personal access tokens']
Tokens (classic)
//span[normalize-space()='Tokens (classic)']

*Generater new token, button, link
//summary[@class='btn btn-sm select-menu-button']
Generater new token (classic), dropdown
//a[1]//div[1]//div[2]

Note
//input[@id='oauth_access_description']
Expireation
//select[@id='oauth_access_default_expires_at']
workflow, checkbox
//input[@value='workflow']
user, checkbox
//input[@value='user']
Generate token, button
//button[normalize-space()='Generate token']

#Challenge
Please create a new project (using source control) and complete the automation tasks described below. Don't hesitate to reach out with potential questions.

GitHub browser testing
GitHub will be used for automating the following tasks. If you're logged into your account please be sure to log out before attempting the automations.

Automation tests
Please automate all items under the topics below (e.g. bullet points with a checkbox 😎).

(IMPORTANT) Please do not use your existing account. Create a new GitHub user with the username of your choice and password of your choice.

Login to GitHub account

 Test incorrect username and password (Assert failing to login to GitHub providing the wrong password)
 Successfully login to GitHub using the credentials from the first task.
Generating a token flow.

Directions: Start from your GitHub user profile view https://github.com/{YOUR_USERNAME_HERE}

Navigate to profile/user settings
Open developer settings from the left navigation menu
Open Personal access tokens from the left menu
click Tokens (classic)
click Generate new token
click Generate new token (classic)
Fill in the token details described in the tasks below (under Tasks/cases).
successfully generate the token
end the flow on the screen following the successful token generation
Tasks/cases

 Generate a token using the following details

NOTE - "QA automations"
Expiration - 7 days
Select Scopes - user and workflow
 Generate a token using the following details

NOTE - "Custom automations"
Expiration - custom with date: 1/22/2024
Select Scopes - only public_repo and read:user scopes
NOTE there should be a total of 2 test cases for #1 and 2 cases for #2. Both tasks in #2 use the same directions but differ in the token details. Please reach out with any potential questions/for clarification.
