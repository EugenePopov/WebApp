package com.company.service;

import com.company.models.ContactEntity;
import com.company.models.PhoneNumberEntity;
import com.company.models.ReportEntity;
import com.company.models.SmsEntity;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//TODO: Comment
//TODO: Test

public class ReportUnmarshallerImpl implements JsonDeserializer<ReportEntity>, ReportUnmarshaller{
    @Override
    public ReportEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {

        JsonObject jsonObject = (JsonObject) jsonElement;

        ReportEntity report = new ReportEntity();

        report.setDate(jsonObject.get("date").getAsString());
        Type listType = new TypeToken<ArrayList<SmsEntity>>(){}.getType();

        List<SmsEntity> smsList = new Gson().fromJson(jsonObject.getAsJsonArray("smsList"), listType);


        listType = new TypeToken<ArrayList<ContactEntity>>(){}.getType();
        List<ContactEntity> contactsList = new Gson().
                fromJson(jsonObject.getAsJsonArray("contactsList"), listType);

        listType = new TypeToken<ArrayList<PhoneNumberEntity>>(){}.getType();
        JsonArray phoneNumbersJsonList = ((JsonObject)(jsonObject.getAsJsonArray("contactsList").get(0)))
                .getAsJsonArray("numbers");
        List<PhoneNumberEntity> phoneNumbersList = new Gson().fromJson(phoneNumbersJsonList, listType);

        for (ContactEntity aContactsList : contactsList) {
            aContactsList.setPhoneNumberEntities(phoneNumbersList);
        }

        report.setSmsEntities(smsList);
        report.setContactEntities(contactsList);

        return report;
    }

    @Override
    public ReportEntity unmarshall(String json) {
        Gson gson = new GsonBuilder().
                registerTypeAdapter(ReportEntity.class, new ReportUnmarshallerImpl()).create();
        return gson.fromJson(json, ReportEntity.class);
    }
}
