package homework29;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ArticlesStarter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        ArticleDao articleDao = context.getBean(ArticleDao.class);

        Article article = new Article("Spring with MongoDB", "This is a simple example of Spring and MongoDB integration.");
        articleDao.saveArticle(article);

        context.close();
    }
}