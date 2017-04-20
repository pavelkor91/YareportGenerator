package service.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectImpl implements JsonObject {
    private final JSONObject src;

    public JsonObjectImpl(JSONObject src) {
        this.src = src;
    }


    public Integer getIntField(String fieldName) {
        try {
            return src.getInt(fieldName);
        } catch (JSONException e) {
            return null;
        }

    }

    public String getStringField(String fieldName) {
        try {
            return src.getString(fieldName);
        } catch (JSONException e) {
            return null;
        }
    }

    public Double getDoubleField(String fieldName) {
        try {
            return src.getDouble(fieldName);
        } catch (JSONException e) {
            return null;
        }
    }

    public JsonObject getObjectField(String fieldName) {
        try {
            return new JsonObjectImpl(src.getJSONObject(fieldName));
        } catch (JSONException e) {
            return null;
        }
    }

    public JsonObject[] getObjectArray(String fieldName) {
        try {
            JSONArray array = src.getJSONArray(fieldName);
            JsonObject[] result = new JsonObject[array.length()];
            for (int i = 0; i < result.length; i++) {
                try {
                    result[i] = new JsonObjectImpl(array.getJSONObject(i));
                } catch (JSONException e) {
                   // throw new ParseException(src.toString(), e);
                }
            }
            return result;
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean hasField(String fieldName) {
        return src.has(fieldName);
    }

    @Override
    public String toString() {
        return src.toString();
    }
}
