package sk.cgc.json_parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    /**
     * Ignores any exception thrown by getting "key" value from json
     * @param json - json object to get the value from
     * @param key -
     * @return Value of "key" from json object or null
     */
    public static String getStringOrNull(JSONObject json, String key) {

        if (json == null || key == null) return null;

        if (json.has(key)) {
            if (json.isNull(key)) return null;
            try {
                return json.getString(key);
            } catch (JSONException ignored) {
                return null;
            }
        }
        return null;
    }

    public static String getStringOrEmpty(JSONObject json, String key) {

        String result = getStringOrNull(json, key);
        if (result == null) result = "";
        return result;
    }

    public static long getLong(JSONObject json, String key) {

        long result = -1;

        if (json.has(key)) {
            try {
                result = json.getLong(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static Long getLongOrNull(JSONObject json, String key) {

        if (json.has(key)) {
            try {
                if (json.isNull(key)) return null;
                return json.getLong(key);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static Double getDoubleOrNull(JSONObject json, String key) {

        if (json.has(key)) {
            if (json.isNull(key)) return null;
            try {
                return json.getDouble(key);
            } catch (JSONException ignored) {
                return null;
            }
        }
        return null;

    }


    public static JSONObject getJsonObjectOrNull(JSONObject json, String key) {

        if (json.has(key)) {
            if (json.isNull(key)) return null;
            try {
                return json.getJSONObject(key);
            } catch (JSONException ignored) {
                return null;
            }
        }
        return null;

    }

    public static JSONObject getJsonObjectOrNull(JSONArray jsonArray, int index) {

        JSONObject object = null;

        try {
            object = jsonArray.getJSONObject(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }

    public static JSONArray getJsonArrayOrNull(JSONObject jsonObject, String key) {

        JSONArray jsonArray = null;

        if (jsonObject.has(key)) {
            if (jsonObject.isNull(key)) return  null;
            try {
                jsonArray = jsonObject.getJSONArray(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }

    public static Boolean getBooleanOrNull(JSONObject jsonObject, String key) {
        if (jsonObject.has(key)) {
            if (jsonObject.isNull(key)) return null;
            try {
                return jsonObject.getBoolean(key);
            } catch (JSONException ignored) {
                return null;
            }
        }
        return null;
    }
    public static Boolean getBooleanOrDefault(JSONObject jsonObject, String key, boolean defValue) {
        if (jsonObject.has(key)) {
            if (jsonObject.isNull(key)) return defValue;
            try {
                return jsonObject.getBoolean(key);
            } catch (JSONException ignored) {
                return defValue;
            }
        }
        return defValue;
    }

    public static Boolean getBooleanOrFalse(JSONObject jsonObject, String key) {

        return getBooleanOrDefault(jsonObject, key, false);

    }


    public static Integer getIntegerOrDefault(JSONObject jsonObject, String key, int defaultValue) {

        Integer result = getIntegerOrNull(jsonObject, key);
        return result != null ? result : defaultValue;

    }
    private static Integer getIntegerOrNull(JSONObject jsonObject, String key) {

        if (jsonObject.has(key)) {
            if (jsonObject.isNull(key)) return null;
            try {
                return jsonObject.getInt(key);
            } catch (JSONException ignored) {
                return null;
            }
        }
        return null;
    }


    public static void put(JSONObject json, String key, String value) {
        try {
            json.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void put(JSONObject json, String key, long value) {
        try {
            json.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
