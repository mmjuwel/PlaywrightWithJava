package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.AfterSuite;

import utils.EmailUtil;

public class TestListener implements ITestListener {

	@AfterSuite
    public void onFinish(ITestContext context) {

        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        int total = passed + failed + skipped;

        EmailUtil.sendEmailReport(total, passed, failed, skipped);

    }
}