# SelleniumCodeChallange
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
