Feature: User Sign Up

    Scenario Outline: Successful Account Creation
        Given user is on sign-up page
        When user enters valid details "<firstName>", "<lastName>", "<email>" and "<password>"
        And user clicks Create Account
        Then user should see a confirmation message
        And user should be redirected to the account dashboard
        And user should see their details on the account dashboard

        Examples:
            | firstName | lastName | email                       | password     |
            | John      | Doe      | john.doe.<random>@gmail.com | password123@ |

    Scenario Outline: Duplicate Email Check
        Given user is on sign-up page
        When user enters valid details "<firstName>", "<lastName>", existing "<email>" and "<password>"
        And user clicks Create Account
        Then user should see an error message indicating the email is already in use

        Examples:
            | firstName | lastName | email              | password     |
            | John      | Doe      | john.koe@gmail.com | password123@ |

    Scenario Outline: Password Strength Validation
        Given user is on sign-up page
        When user enters "<firstName>", "<lastName>", "<email>" and weak password "<password>"
        Then user should see an error message indicating the password does not meet strength requirements

        Examples:
            | firstName | lastName | email                       | password   |
            | John      | Doe      | john.doe.weak@gmail.com     | pass123    |