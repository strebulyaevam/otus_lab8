package lab8.steps;

import config.Lab8Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lab8.TestConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfig.class)
public class CommonSteps {

    @Autowired
    Lab8Config cfg;

    private static Logger Log = LogManager.getLogger(CommonSteps.class);


     @Before
      public void before() {
     }

      @After
       public void after() {
      }

}
