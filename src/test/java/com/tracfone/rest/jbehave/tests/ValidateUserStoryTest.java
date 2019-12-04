package com.tracfone.rest.jbehave.tests;

import com.tracfone.rest.jbehave.steps.ValidateUserSteps;

/**
 * @author aiet
 */
public class ValidateUserStoryTest extends AbstractStory {

    @Override
    String storyName() {
        return "stories/validate_user.story";
    }

    @Override
    Object stepInstance() {
        return new ValidateUserSteps();
    }

}
