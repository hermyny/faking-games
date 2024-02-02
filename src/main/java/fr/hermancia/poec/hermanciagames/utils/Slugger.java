package fr.hermancia.poec.hermanciagames.utils;

import org.springframework.stereotype.Component;
import java.util.regex.Pattern;
import java.text.Normalizer;
import java.util.Locale;

@Component
public class Slugger {


        private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
        private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

        public String slugify(String input) {
            String noWhitespace = WHITESPACE.matcher (input).replaceAll("-");
            String normalized = Normalizer.normalize(noWhitespace, Normalizer.Form.NFD);
            String slug = NONLATIN.matcher(normalized).replaceAll("");
            return slug.toLowerCase(Locale.ENGLISH);
        }
}
