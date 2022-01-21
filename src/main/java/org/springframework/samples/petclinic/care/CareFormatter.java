package org.springframework.samples.petclinic.care;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CareFormatter implements Formatter<Care>{

    @Autowired
    CareService careService;
    @Override
    public String print(Care object, Locale locale) {
        return object.getName();
    }

    @Override
    public Care parse(String text, Locale locale) throws ParseException {
        Collection<Care> list=careService.getAllCares();
        for (Care care : list) {
            if(care.getName().equals(text)) return care;
        }
        throw new ParseException("care not found: " + text, 0);
    }
    
}
