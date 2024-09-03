package com.hcl.authorizationfinal.service;

import com.hcl.authorizationfinal.dto.rule.CreateBusinessRuleInputJson;
import com.hcl.authorizationfinal.jsontodrl.JsonToDrlConvertor;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class BusinessRuleService {

    private final JsonToDrlConvertor jsonToDrlConvertor;

    public BusinessRuleService(JsonToDrlConvertor jsonToDrlConvertor) {
        this.jsonToDrlConvertor = jsonToDrlConvertor;
    }

    /**
     * Process the input JSON to generate Drools rules.
     *
     * @param inputJson The input JSON containing business rules
     * @throws Exception If there is an error during processing
     */
    public void processBusinessRule(CreateBusinessRuleInputJson inputJson) throws Exception {
        // Convert JSON to Drools DRL
        String drl = jsonToDrlConvertor.convertJsonToDrl(inputJson);

        // Here you could save the DRL to a file, database, or some other storage
        // For example, saving it to a file:
        saveDrlToFile(drl);

        // Alternatively, you might want to deploy the DRL to a Drools engine
        // deployToDroolsEngine(drl);

        // Placeholder for saving or deploying the DRL
        System.out.println("Generated DRL:\n" + drl);
    }

    // Example method to save DRL to a file
    private void saveDrlToFile(String drl) {
        // Define the directory and file path
        String directoryPath = "src/main/resources";
        String fileName = "drlfile.drl";
        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        // Create the directory if it does not exist
        if (!directory.exists()) {
            boolean dirsCreated = directory.mkdirs();
            if (!dirsCreated) {
                System.err.println("Failed to create directory: " + directoryPath);
                return;
            }
        }

        // Use try-with-resources to ensure the BufferedWriter is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Write the DRL content to the file
            writer.write(drl);
            System.out.println("DRL file saved successfully at " + file.getAbsolutePath());
        } catch (IOException e) {
            // Handle file I/O errors
            System.err.println("Error writing DRL file: " + e.getMessage());
        }
    }
    // Example method to deploy DRL to a Drools engine
    private void deployToDroolsEngine(String drl) {
        // Implement deployment logic here
    }
}
