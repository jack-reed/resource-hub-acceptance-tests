Feature: Visit a page and click on a link

  @test
  Scenario: Visit a page and check the page title
    Given I go to url https://ddcn-resource-hub.herokuapp.com
    When I click on the link by text with: Start now
    Then I should be on the Resources available page
    When I click on the link by text with: Collaboration Pod 1
    Then I should be on the Book a Resource page
    When I fill in the form
      | Form ID     | Content        |
      | name        | Jack           |
      | description | Jack's Booking |
      | startTime   | 10:00          |
      | startDay    | 25             |
      | endTime     | 11:00          |
      | endDay      | 25             |
    When I click on the submit button
    Then I should be on the Confirmation page
    And I remove the booking
    When I click on the submit button
