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

//TODO: Test

public class ReportUnmarshallerImpl implements JsonDeserializer<ReportEntity>, ReportUnmarshaller{

    /**
     * Method performs custom deserialization, overriding deserialize method from GSON library.
     * Custom serialization is needed because of One-To-Many relationship
     * between ReportEntity and Sms and Contact entities. Dependent entities (SmsEntity and ContactEntity) must have
     * ReportEntity attribute, annotated with @Many-To-One Hibernate annotation,
     * which must be set during deserialization.
     *
     * @param jsonElement json retrieved from HTTP body
     * @param type legacy parameter. For details see GSON documentation
     * @param context legacy parameter. For details see GSON documentation
     * @return serialized instance of ReportEntity class
     * @throws JsonParseException in case of malformed JSON
     */
    @Override
    public ReportEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {

        JsonObject jsonObject = (JsonObject) jsonElement;

        ReportEntity report = new ReportEntity();

        report.setDate(jsonObject.get("date").getAsString());

        List<SmsEntity> smsList = getSmsList(jsonObject);
        List<ContactEntity> contactsList = getContactsList(jsonObject);

        for(SmsEntity s : smsList){
            s.setReport(report);
        }

        for(ContactEntity c : contactsList){
            c.setReport(report);
        }

        setPhoneNumbersContact(jsonObject, contactsList);

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

    /**
     * Retrieve list of phone numbers for every contact
     * and populates the contactEntity field of PhoneNumberEntity class,
     * annotated with One-To-Many Hibernate annotation.
     * @param jsonObject json retrieved from HTTP body
     * @param contactsList list of all contactEntities from received JSON
     */
    private void setPhoneNumbersContact(JsonObject jsonObject, List<ContactEntity> contactsList){
        for(int i = 0; i< contactsList.size(); i++) {
            Type listType = new TypeToken<ArrayList<PhoneNumberEntity>>() {
            }.getType();
            JsonArray phoneNumbersJsonList = ((JsonObject) (jsonObject.getAsJsonArray("contactsList").get(i)))
                    .getAsJsonArray("numbers");
            List<PhoneNumberEntity> phoneNumbersList = new Gson().fromJson(phoneNumbersJsonList, listType);

            for (PhoneNumberEntity n : phoneNumbersList) {
                n.setContactEntity(contactsList.get(i));
            }

            contactsList.get(i).setPhoneNumberEntities(phoneNumbersList);
        }
    }

    /**
     * Retrieve all the SMSs from received JSON, using customized unmarshaller (SmsUnmarshaller)
     * @param jsonObject json retrieved from HTTP body
     * @return list of SmsEntity objects
     */
    private List<SmsEntity> getSmsList(JsonObject jsonObject){

        Type listType = new TypeToken<ArrayList<SmsEntity>>(){}.getType();
        Gson gson = new GsonBuilder().
                registerTypeAdapter(SmsEntity.class, new SmsUnmarshaller()).create();
        return gson.fromJson(jsonObject.getAsJsonArray("smsList"), listType);

    }

    /**
     * Retrieve all the contacts from received JSON
     * @param jsonObject json retrieved from HTTP body
     * @return list of ContactEntity objects
     */
    private List<ContactEntity> getContactsList(JsonObject jsonObject){

        Type listType = new TypeToken<ArrayList<ContactEntity>>(){}.getType();
        Gson gson = new Gson();
        return gson.fromJson(jsonObject.getAsJsonArray("contactsList"), listType);
    }
}
