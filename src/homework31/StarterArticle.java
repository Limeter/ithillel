package homework31;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StarterArticle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CommandsProcessor processor = context.getBean(CommandsProcessor.class);
        processor.run();
        context.close();
    }
}
