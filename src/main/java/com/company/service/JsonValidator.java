package com.company.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonValidator {

    private JsonSchema getJsonSchemaFromStringContent(String schemaContent) throws Exception {
        JsonSchemaFactory factory = new JsonSchemaFactory();
        return factory.getSchema(schemaContent);
    }

    private JsonNode getJsonNodeFromStringContent(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(content);
    }

    /**
     * Method verifies if received Json satisfies Json schema.
     * @param json received JSON
     * @return true if json is valid, otherwise - false
     * @throws Exception at parsing Json schema
     */
    public boolean isValid(String json) throws Exception {

        //TODO: change path
        String fileName = "C:\\Users\\epopov\\IdeaProjects\\WebApp\\src\\main\\resources\\report-schema.json";
        String jsonSchema = "";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            jsonSchema = stream.collect(Collectors.joining());

        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonSchema schema =getJsonSchemaFromStringContent(jsonSchema);

        Set<ValidationMessage> errors = schema.validate(getJsonNodeFromStringContent(json));

        return errors.isEmpty();
    }
}