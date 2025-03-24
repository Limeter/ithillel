package homework32;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class ArticleDto {
    private final String title;
    private final String text;
    private final boolean isPublished;
    private final String authorID;

    public ArticleDto(String title, String text, boolean isPublished, String authorID) {
        this.title = title;
        this.text = text;
        this.isPublished = isPublished;
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
}

@Service
class ArticleDao {
    private final MongoCollection<Document> articleCollection;

    public ArticleDao(MongoDatabase database) {
        this.articleCollection = database.getCollection("articles");
    }

    public List<ArticleDto> findAllArticles() {
        List<ArticleDto> articles = new ArrayList<>();
        FindIterable<Document> docs = articleCollection.find();
        for (Document doc : docs) {
            articles.add(new ArticleDto(
                    doc.getString("title"),
                    doc.getString("text"),
                    doc.getBoolean("isPublished"),
                    doc.getString("authorID")
            ));
        }
        return articles;
    }
}

