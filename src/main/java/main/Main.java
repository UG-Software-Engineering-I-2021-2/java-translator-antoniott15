package main;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import translate.Translator;

public class Main {
    static final String EnglishLanguage = "en";
    static final String SpanishLanguage = "es";
    static final Logger CustomLogger = Logger.getLogger(Main.class.getName());

    public void main(String[] args) throws Exception {
        String result = this.translate(SpanishLanguage, EnglishLanguage);
        this.CustomLogger.info(String.format( "Texto traducido: %s" , result));
    }

    public String translate(String translateFrom, String translateTo) throws IOException {
        Scanner input = new Scanner(System.in);
        this.CustomLogger.info("Escribe la oracion a traducir (español a ingles): ");
        String textToTranslate = input.nextLine();

        return Translator.translate(translateFrom, translateTo, textToTranslate);
    }
}
