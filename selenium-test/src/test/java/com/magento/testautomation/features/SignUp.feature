Feature: User Sign Up

    Scenario Outline: Successful Account Creation
        Given user is on sign-up page
        When user enters valid details "<firstName>", "<lastName>", email and "<password>"
        And user clicks Create Account
        Then user should see a confirmation message
        And user should be redirected to the account dashboard
        And user should see their details on the account dashboard
        
        Examples:
            | firstName | lastName | password     |
            | John      | Doe      | password123@ |