package main;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import translate.Translator;

public class Main {
    static final String ENGLISH_LANGUAGE = "en";
    static final String SPANISH_LANGUAGE = "es";
    static final Logger CUSTOM_LOGGER = Logger.getLogger(Main.class.getName());

    public void main() {
        Scanner input = new Scanner(System.in);
        CUSTOM_LOGGER.info("Escribe la oracion a traducir (español a ingles): ");
        String textToTranslate = input.nextLine();

        try {
            String response = Translator.translate(SPANISH_LANGUAGE, ENGLISH_LANGUAGE, textToTranslate);
            CUSTOM_LOGGER.info(String.format("La oracion al ingles es: %s", response));
        }catch (IOException e) {
            CUSTOM_LOGGER.info(String.format("Whoops something goes bad:{0} ", e));
        }
    }
}
