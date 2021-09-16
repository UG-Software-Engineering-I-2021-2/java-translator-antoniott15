package main;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import translate.Translator;
public class Main {
    static final String englishLenguage = "en";
    static final String spanishLenguage = "es";
    public Logger logger;

    public void main(String[] args) throws Exception {
        Logger newLogger;
        newLogger = Logger.getLogger(Main.class.getName());
        this.logger = newLogger;

        String result = Translate(spanishLenguage, englishLenguage);
        this.logger.info("Texto traducido: " + result);
    }

    public String Translate(String translateFrom, String translateTo) throws IOException {
        Scanner input = new Scanner(System.in);
        this.logger.info("Escribe la oracion a traducir (español a ingles): ");

        String textToTranslate = input.nextLine();

        String resultTranslated = Translator.translate(translateFrom, translateTo, textToTranslate);

        return resultTranslated;
    }
}
