package listeners;

import com.google.constants.Browser;
import com.google.constants.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IAlterSuiteListener;
import org.testng.IAnnotationTransformer;
import org.testng.xml.XmlSuite;

import java.util.HashMap;
import java.util.List;

import static com.google.constants.Browser.DEFAULT_BROWSER;
import static com.google.constants.Environment.DEFAULT_ENVIRONMENT;
import static com.google.constants.TestParameters.PARAMETER_BROWSER;
import static com.google.constants.TestParameters.PARAMETER_ENVIRONMENT;
import static java.lang.String.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class AlterSuiteListener implements IAlterSuiteListener, IAnnotationTransformer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlterSuiteListener.class);

    @Override
    public void alter(List<XmlSuite> suites) {
        suites.forEach(suite -> {
            HashMap<String, String> map = new HashMap<>();
            map.put(PARAMETER_ENVIRONMENT, getEnvironmentParameterValue(suite));
            map.put(PARAMETER_BROWSER, getBrowserParameterValue(suite));
            suite.setParameters(map);
            LOGGER.info(format("PARAMETERS INJECTED INTO XML SUITE: %s ", map.toString()));
        });
    }

    private String getEnvironmentParameterValue(XmlSuite suite) {
        String xmlValue = suite.getParameter(PARAMETER_ENVIRONMENT);
        String firstPriorityValue = Environment.contains(xmlValue) ? xmlValue : EMPTY;
        String secondPriorityValue = DEFAULT_ENVIRONMENT.name();
        return getParameterValue(PARAMETER_ENVIRONMENT, firstPriorityValue, secondPriorityValue);
    }

    private String getBrowserParameterValue(XmlSuite suite) {
        String xmlValue = suite.getParameter(PARAMETER_BROWSER);
        String firstPriorityValue = Browser.contains(xmlValue) ? xmlValue : EMPTY;
        String secondPriorityValue = DEFAULT_BROWSER.getDisplayName();
        return getParameterValue(PARAMETER_BROWSER, firstPriorityValue, secondPriorityValue);
    }

    private String getParameterValue(String parameterName, String firstPriority, String secondPriority) {
        String parameterValue = firstPriority.isEmpty() ? secondPriority : firstPriority;
        LOGGER.info(format("%n [%s] XML PARAMETER: %s %n [%s] EXECUTION PARAMETER: %s", parameterName, firstPriority,
                parameterName, parameterValue));
        return parameterValue;
    }
}
