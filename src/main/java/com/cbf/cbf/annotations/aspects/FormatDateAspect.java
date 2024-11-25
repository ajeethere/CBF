package com.cbf.cbf.annotations.aspects;

import com.cbf.cbf.annotations.FormatDate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class FormatDateAspect {

    @PrePersist
    @PreUpdate
    public void validateAndFormatDates(Object entity) {
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FormatDate.class)) {
                FormatDate annotation = field.getAnnotation(FormatDate.class);
                String pattern = annotation.pattern();
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

                field.setAccessible(true); // Allow access to private fields
                try {
                    Object value = field.get(entity);

                    if (value != null) {
                        if (value instanceof Date) {
                            // Reformat date to the specified pattern
                            String formattedDate = dateFormat.format(value);
                            field.set(entity, dateFormat.parse(formattedDate));
                        } else if (value instanceof String) {
                            // Validate and parse string to Date
                            field.set(entity, dateFormat.parse((String) value));
                        }
                    }
                } catch (IllegalAccessException | ParseException e) {
                    throw new IllegalArgumentException("Invalid date format for field '" + field.getName() +
                            "'. Expected format: " + pattern, e);
                }
            }
        }
    }
}
