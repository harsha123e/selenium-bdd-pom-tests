Feature: User Sign In

    Scenario Outline: Successful Login
        Given user navigates to the login page
        When user enters "<email>" and "<password>"
        And user clicks Sign In
        Then user should successfully log in
        And user should see the account dashboard

        Examples:
            | email             | password     |
            | johnkoe@gmail.com | password123@ |
    
    Scenario Outline: Invalid Login Attempt
        Given user navigates to the login page
        When user enters invalid credentials "<email>" and "<password>"
        And user clicks Sign In
        Then user should see an error message indicating incorrect credentials

        Examples:
            | email               | password       |
            | invaliduser@xyz.com | wrongpassword  |

    Scenario: Logout Functionality
        Given user is logged into their account
        When user clicks on the logout button
        Then user should be redirected to the sign out page