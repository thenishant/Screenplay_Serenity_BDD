package utils;

public class TestContext {

    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    ScenarioContext scenarioContext;

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
