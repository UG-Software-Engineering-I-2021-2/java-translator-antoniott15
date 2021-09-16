package translatorTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import translate.Translator;

import java.io.IOException;
import java.sql.Time;

public class TranslatorParallelTest {

    @Test(threadPoolSize = 80, invocationCount = 80, timeOut = 2000)
    public void TestTranslation() throws IOException {
        long begin = System.currentTimeMillis();
        String translate = Translator.translate("es","en","Hola Mundo");
        Assert.assertEquals(translate, "Hello World");
        long finish = System.currentTimeMillis();

        if(finish-begin > 4000000) {
            Assert.fail();
        }
    }
}
