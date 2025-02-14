Feature: Validation of PLace APIs

Scenario: Verify the place is successfully added

     Given Add place playload
     When user calls AddplaceAPI with post request
     Then the API call is success the verify status code 200
     And status code is response body is OK
     







