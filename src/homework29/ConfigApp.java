package homework29;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
@Configuration
@ComponentScan("homework30")
public class ConfigApp {
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoDatabase mongoDatabase(MongoClient mongoClient) {
        return mongoClient.getDatabase("mydatabase");
    }
}

class Article {
    private String title;
    private String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Document toDocument() {
        return new Document("title", title).append("text", text);
    }
}

@Service
class ArticleDao {
    private final MongoCollection<Document> articleCollection;

    public ArticleDao(MongoDatabase database) {
        this.articleCollection = database.getCollection("articles");
    }

    public void saveArticle(Article article) {
        articleCollection.insertOne(article.toDocument());
        System.out.println("Article saved: " + article.getTitle());
    }
}