Feature: Main test cases related to the strypes.eu site

  Background: Navigate to the home page
    * I load "Home" page

  Scenario: Verify specific job availability
    When I load "Careers" page
    Then The following job titles should be present
      | Python Developer |

  Scenario: Verify the search functionality
    When I search for "Developer" term
    Then The displayed results should contains "Developer" term

  Scenario: Verify applying for a new job
    When I load "Careers" page
    When I view "Python Developer" position
    Then I should be able to apply for the selected position

  Scenario: Verify the contact form functionality
    Given I load "Contact" page
    When I input the following information
      | First name | Last name | Email                        | Company name               | Message                  |
      | Yamatoshi  | Shagamoto | yamatoshishagamoto@tcwlm.com | YamatoshiShagamoto Limited | String message goes here |
    Then The message should be send successfully

  Scenario: Verify the media filter
    Given I load "Media" page
    When I select the "Blog" post type
    Then All displayed publication should be from type "Blog"