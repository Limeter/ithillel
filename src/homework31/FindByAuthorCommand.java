package homework31;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Scanner;

@Component("findByAuthor")
public class FindByAuthorCommand implements TerminalCommand {
    @Resource
    DaoArticle daoArticle;

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter author ID:");
        String authorID = s.nextLine();
        daoArticle.findByAuthor(authorID);
    }
}
