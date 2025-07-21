package com.db.hackathon.credit_api;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.hackathon.credit_api.client.OpenAIClient;
import com.db.hackathon.credit_api.helper.RecordLoader;

@SpringBootTest
class CreditApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testOpenAIClient() throws IOException {

		RecordLoader recordLoader = new RecordLoader();
		recordLoader.getExamplesAsPrompt();

		OpenAIClient openAIClient = new OpenAIClient("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",recordLoader);

		System.out.println("Credit Score: " + openAIClient.getCreditScore());

	}

}
