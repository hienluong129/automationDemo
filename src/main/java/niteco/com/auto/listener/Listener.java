package niteco.com.auto.listener;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter  {
@Override
public void onTestStart(ITestResult tr){
	log("Test Started...");
}
@Override
public void onTestSuccess(ITestResult tr) {

	log("Test '" + tr.getName() + "' PASSED");

	log(tr.getTestClass());
	log("Priority of this method is " + tr.getMethod().getPriority());
	System.out.println(".....");
}

@Override
public void onTestFailure(ITestResult tr) {

	log("Test '" + tr.getName() + "' FAILED");
	log("Priority of this method is " + tr.getMethod().getPriority());
	System.out.println(".....");
}

private void log(String methodName) {
	System.out.println(methodName);
}

private void log(IClass testClass) {
	System.out.println(testClass);
}
}
