package homework30;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StarterArticles {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DaoArticle articleDao = context.getBean(DaoArticle.class);

        Articl article = new Articl("Spring with MongoDB", "This is a simple example of Spring and MongoDB integration.");
        articleDao.saveArticle(article);

        System.out.println("🔎 Articles with title 'Spring with MongoDB':");
        articleDao.findByTitle("Spring with MongoDB");

        articleDao.publishArticle("Spring with MongoDB");

        System.out.println("✅ Published articles:");
        articleDao.findPublishedByTitle("Spring with MongoDB");

        context.close();
    }
}
