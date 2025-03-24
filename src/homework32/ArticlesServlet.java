package homework32;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/articles")
public class ArticlesServlet extends HttpServlet {
    @Autowired
    private ArticleDao articleDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        List<ArticleDto> articles = articleDao.findAllArticles();
        Gson gson = new Gson();
        String json = gson.toJson(articles);
        out.print(json);
        out.flush();
    }
}
