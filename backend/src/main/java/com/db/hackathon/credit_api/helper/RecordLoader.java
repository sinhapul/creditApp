package com.db.hackathon.credit_api.helper;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecordLoader {
    private final List<String> examples = new ArrayList<>();

    @PostConstruct
    public void loadCSV() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/records.csv"))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String formatted = String.format("""
                    Age: %s
                    gender: %s
                    Loacation: %s
                    ec bill: %s
                    ec bill amount: %s
                    Credit Score: %s
                    """, data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                examples.add(formatted);
            }
        }
    }

    public String getExamplesAsPrompt()  {
        return String.join("\n---\n", examples);
    }
}
