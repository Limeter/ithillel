package homework35;

import java.sql.*;

public class CreatorDAO {
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Creator getAuthorWithArticles(int authorId) {
        String query = "SELECT a.id, a.name, ar.title, ar.text " +
                "FROM author a " +
                "LEFT JOIN articles ar ON a.id = ar.author_id " +
                "WHERE a.id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, authorId);
            ResultSet rs = stmt.executeQuery();

            Creator author = null;
            while (rs.next()) {
                if (author == null) {
                    author = new Creator(rs.getInt("id"), rs.getString("name"));
                }
                String title = rs.getString("title");
                String text = rs.getString("text");
                if (title != null) {
                    author.addArticle(new Artifact(title, text, author));
                }
            }
            return author;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Creator author = getAuthorWithArticles(1);
        System.out.println(author);
    }
}
