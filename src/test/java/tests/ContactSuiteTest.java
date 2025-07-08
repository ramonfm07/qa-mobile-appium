package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AddContactTest.class,
        AddContactNegativeTest.class,
        EditContactTest.class,
        DeleteContactTest.class
})
public class ContactSuiteTest {
}
