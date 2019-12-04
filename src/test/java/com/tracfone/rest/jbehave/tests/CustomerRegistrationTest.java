package com.tracfone.rest.jbehave.tests;

import com.tracfone.rest.jbehave.steps.CustomerRegistrationSteps;

public class CustomerRegistrationTest extends AbstractStory {

    @Override
    String storyName() {
        return "stories/customer_registration.story";
    }

    @Override
    Object stepInstance() {
        return new CustomerRegistrationSteps();
    }
}
