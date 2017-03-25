package com.company.service;

import com.company.models.SmsEntity;
import com.google.gson.*;
import java.lang.reflect.Type;

public class SmsUnmarshaller implements JsonDeserializer<SmsEntity> {
    @Override
    public SmsEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {

        JsonObject jsonObject = (JsonObject) jsonElement;

        SmsEntity smsEntity = new SmsEntity();

        smsEntity.setAddress(jsonObject.get("address").getAsString());
        smsEntity.setMessage(jsonObject.get("message").getAsString());
        smsEntity.setDate(jsonObject.get("date").getAsString());
        smsEntity.setSmsType(jsonObject.get("smsType").getAsString());

        return smsEntity;
    }
}
