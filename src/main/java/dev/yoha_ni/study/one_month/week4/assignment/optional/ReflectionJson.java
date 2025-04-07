package dev.yoha_ni.study.one_month.week4.assignment.optional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * 제로베이스 35기 서요한
 */
public class ReflectionJson {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            JsonSerializer serializer = new JsonSerializer();
            String json = serializer.serialize(person);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class JsonSerializer {
    public String serialize(Object object) throws IllegalAccessException {

        Class<?> clazz = object.getClass();
        Map<String, Object> jsonMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            JsonField jsonField = field.getAnnotation(JsonField.class);

            if (jsonField.skipYn()) {
                continue;
            }
            field.setAccessible(true);

            jsonMap.put(jsonField.value(), field.get(object));
        }

        return mapToJson(jsonMap);

    }

    private String mapToJson(Map<String, Object> map) {
        StringBuilder jsonBuilder = new StringBuilder("{");
        boolean first = true;

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!first) {
                jsonBuilder.append(",");
            }
            first = false;

            jsonBuilder.append(entry.getKey()).append(": ");

            Object value = entry.getValue();
            if (value instanceof String) {
                jsonBuilder.append("\"").append(value).append("\"");
            } else {
                jsonBuilder.append(value);
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {

    String value();

    boolean skipYn() default false;
}

class Person {

    @JsonField(value = "full_name")
    private String name = "zeroBase";

    @JsonField(value = "age")
    private int age = 5;

    @JsonField(value = "age", skipYn = true)
    private String gender = "F";


}
