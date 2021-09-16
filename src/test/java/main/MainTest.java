package main;

import main.Main;
import org.testng.Assert;
import org.testng.annotations.Test;



public class MainTest  {

    @Test
    public void testToLenguage() {
        String en = Main.ENGLISH_LANGUAGE;
        Assert.assertEquals(en,"en");
    }

    @Test
    public void testFromLenguage() {
        String en = Main.SPANISH_LANGUAGE;
        Assert.assertEquals(en,"es");
    }
}