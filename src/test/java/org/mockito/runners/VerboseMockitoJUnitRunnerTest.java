package org.mockito.runners;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.mockito.internal.runners.InternalRunner;
import org.mockito.internal.util.ConsoleMockitoLogger;
import org.mockitoutil.TestBase;

import static org.junit.Assert.assertEquals;

public class VerboseMockitoJUnitRunnerTest extends TestBase {

    private VerboseMockitoJUnitRunner runner;



    private RunNotifier notifier;

    @Before
    public void setup() throws InitializationError {
        notifier = new RunNotifier();
    }

    @Test
    public void shouldDelegateToGetDescription() throws Exception {
        //given
        final Description expectedDescription = Description.createSuiteDescription(this.getClass());
        runner = new VerboseMockitoJUnitRunner(new ConsoleSpammingMockitoJUnitRunnerTest.InternalRunnerStub() {
            public Description getDescription() {
                return expectedDescription;
            }
        });

        //when
        Description description = runner.getDescription();

        //then
        assertEquals(expectedDescription, description);
    }
}
