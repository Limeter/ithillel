package homework30;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan("homework29")
public class AppConfig {
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoDatabase mongoDatabase(MongoClient mongoClient) {
        return mongoClient.getDatabase("mydatabase");
    }
}

class Articl {
    private String title;
    private String text;
    private boolean isPublished;

    public Articl(String title, String text) {
        this.title = title;
        this.text = text;
        this.isPublished = false;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public Document toDocument() {
        return new Document("title", title)
                .append("text", text)
                .append("isPublished", isPublished);
    }
}

@Service
class DaoArticle {
    private final MongoCollection<Document> articleCollection;

    public DaoArticle(MongoDatabase database) {
        this.articleCollection = database.getCollection("articles");
    }

    public void saveArticle(Articl article) {
        articleCollection.insertOne(article.toDocument());
        System.out.println("Article saved: " + article.getTitle());
    }

    public void findByTitle(String title) {
        FindIterable<Document> articles = articleCollection.find(Filters.eq("title", title));
        for (Document doc : articles) {
            System.out.println(doc.toJson());
        }
    }

    public void findPublishedByTitle(String title) {
        FindIterable<Document> articles = articleCollection.find(
                Filters.and(Filters.eq("title", title), Filters.eq("isPublished", true))
        );
        for (Document doc : articles) {
            System.out.println(doc.toJson());
        }
    }

    public void publishArticle(String title) {
        articleCollection.updateOne(
                Filters.eq("title", title),
                Updates.set("isPublished", true)
        );
        System.out.println("Article '" + title + "' has been published.");
    }
}

