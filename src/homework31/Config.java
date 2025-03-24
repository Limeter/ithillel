package homework31;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan("homework30")
public class Config {
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
    private final String title;
    private final String text;
    private final boolean isPublished;
    private final String authorID;

    public Article(String title, String text, String authorID) {
        this.title = title;
        this.text = text;
        this.isPublished = false;
        this.authorID = authorID;
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

    public String getAuthorID() {
        return authorID;
    }

    public Document toDocument() {
        return new Document("title", title)
                .append("text", text)
                .append("isPublished", isPublished)
                .append("authorID", authorID);
    }
}

@Service
class DaoArticle {
    private final MongoCollection<Document> articleCollection;

    public DaoArticle(MongoDatabase database) {
        this.articleCollection = database.getCollection("articles");
    }

    public void saveArticle(Article article) {
        articleCollection.insertOne(article.toDocument());
        System.out.println("Article saved: " + article.getTitle());
    }

    public void findByAuthor(String authorID) {
        FindIterable<Document> articles = articleCollection.find(Filters.eq("authorID", authorID));
        for (Document doc : articles) {
            System.out.println(doc.toString());
        }
    }

    public void findPublishedByAuthor(String authorID) {
        FindIterable<Document> articles = articleCollection.find(
                Filters.and(Filters.eq("authorID", authorID), Filters.eq("isPublished", true))
        );
        for (Document doc : articles) {
            System.out.println(doc.toString());
        }
    }
}
