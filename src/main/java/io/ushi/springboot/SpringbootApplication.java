package io.ushi.springboot;

import io.ushi.springboot.domain.mongo.Document;
import io.ushi.springboot.repository.mongo.MongoDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    @Autowired
    private MongoDocumentRepository mongoDocumentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Document doc = new Document();
        doc.setGroupId("mongoG");
        doc.setArtifactId("mongoA");
        doc.setVersion("mongoV");

        mongoDocumentRepository.save(doc);
    }
}
