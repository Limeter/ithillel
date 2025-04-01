package homework35;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    private int id;
    private String name;
    private List<Artifact> articles = new ArrayList<>();

    public Creator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addArticle(Artifact article) {
        articles.add(article);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", articles=" + articles +
                '}';
    }
}