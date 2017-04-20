package service.json;
import org.json.JSONException;
import org.json.JSONObject;
import entity.Counter;
import entity.MetrikaError;

import java.text.ParseException;

public class JsonMapperImpl implements JsonMapper {

    private Counter parseCounter(JsonObject jsonObject) {
        Counter result = new Counter();
        result.setId(jsonObject.getIntField("id"));
        result.setSite(jsonObject.getStringField("site"));
        result.setName(jsonObject.getStringField("name"));
        return result;
    }

    private MetrikaError parseError(JsonObject jsonObject) {
        return new MetrikaError(jsonObject.getIntField("id"), jsonObject.getStringField("text"),
                jsonObject.getStringField("code"));
    }

    public <T> T jsonObjectToEntity(JsonObject jsonObject, Class<T> clazz) {
        if (Counter.class.equals(clazz)) {
            //noinspection unchecked
            return (T) parseCounter(jsonObject);
        } else if (MetrikaError.class.equals(clazz)) {
            //noinspection unchecked
            return (T) parseError(jsonObject);
        } else {
            throw new UnsupportedOperationException("Entity class " + clazz.getName() + " is not supported");
        }
    }

    public String entityToString(Object entity) {
        throw new UnsupportedOperationException();
    }

   /* public JsonObject stringToJsonObject(String source) {
        try {
            return new JSONObject(new JSONObject(source));
        } catch (JSONException e) {
            throw new ParseException(source, e);
        }
    }*/
}