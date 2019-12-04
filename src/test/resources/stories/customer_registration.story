Meta:

Narrative: Customer Registration Test

Scenario: create customer with json request

Given demoQA api

When I pass in json request via the api to register
Then api respond: 200