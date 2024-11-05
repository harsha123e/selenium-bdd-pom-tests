Feature: User Account Management

    Scenario Outline: Successful Login
        Given user navigates to the login page
        When user enters "<email>" and "<password>"
        And user clicks Sign In
        Then user should successfully log in
        And user should see the account dashboard

        Examples:
            | email | password     |
            | johnkoe@gmail.com | password123@ |