package com.db.hackathon.credit_api.helper;

import jakarta.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


@Component
public class RecordLoader {

    private final List<String> examples = new ArrayList<>();

    @PostConstruct
    public void loadCSV() {
        try {
            ClassPathResource res = new ClassPathResource("records.csv");
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(res.getInputStream(), StandardCharsets.UTF_8))) 
            {
                String header = br.readLine(); // skip header
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    // Adjust indices to match your CSV columns!
                    String formatted = String.format("""
                        Age: %s
                        Gender: %s
                        Location: %s
                        Water Bill: %s
                        Electricity Bill: %s
                        Property Papers: %s

                        Property Bill:
                          Due Date : %s
                          Paid Date: %s

                        School Fees Bill:
                          Due Date : %s
                          Paid Date: %s

                        Credit Score: %s
                        """,
                        data[0],  // age
                        data[1],  // gender
                        data[2],  // location
                        data[3],  // water bill
                        data[4],  // electricity bill
                        data[5],  // property papers (Yes/No)
                        data[6],  // property-bill due date
                        data[7],  // property-bill paid date
                        data[8],  // school-fees due date
                        data[9],  // school-fees paid date
                        data[10]  // credit score
                    );
                    examples.add(formatted);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load records.csv from classpath", e);
        }
    }

    /**
     * Returns all loaded examples joined by separators,
     * suitable to append to your LLM system prompt.
     */
    public String getExamplesAsPrompt() {
        return String.join("\n---\n", examples);
    }
}