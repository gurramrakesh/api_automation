Meta:

Narrative:
As a user
I want to look up a user in gitHUb and assert response

Scenario: when a user checks a  user on github, github would respond

Given github user profile api

When I look for gurramrakesh via the api
Then github respond: 200

When I look for tesat324 via the api
Then github respond: 404 not found
