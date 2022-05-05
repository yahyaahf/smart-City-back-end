package ma.uiass.eia.persistency.entities;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateHandler extends StdDeserializer<LocalDate> {
    public DateHandler(){
        this(null);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JacksonException {
        String date=p.getText();
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            return null;
        }
    }

    public DateHandler(Class<?> clazz){
        super(clazz);
    }
}
