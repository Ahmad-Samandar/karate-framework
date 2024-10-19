package runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    @Test
    public void runTest() {
        // List to hold paths of specific features
        List<String> featurePaths = new ArrayList<>();

        // Add specific feature paths as needed, else leave it empty to run all features
        featurePaths.add("classpath:features/tokens/operatorToken.feature");
        featurePaths.add("classpath:features/tokens/supervisorToken.feature");
        featurePaths.add("classpath:features/accounts/Account.feature");


        // Dynamic parameters
        String tags = System.getProperty("karate.tags", "@Regression");

        Results results;
        if (featurePaths.isEmpty()) {
            // Run all features under the "features" folder if no specific paths are provided
            results = Runner.path("classpath:features")
                    .tags(tags)
                    .parallel(5);
        } else {
            // Run specific features listed in 'featurePaths'
            results = Runner.path(featurePaths)
                    .tags(tags)
                    .parallel(5);
        }

        // Assertions to fail the test if any scenarios failed
        Assertions.assertEquals(0, results.getFailCount(), "There are scenario failures");
    }
}
