package homework35;

import java.sql.*;

public class ArtifactRepository {
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Artifact getArticleWithAuthor(String articleTitle) {
        String query = "SELECT ar.title, ar.text, a.id, a.name " +
                "FROM articles ar " +
                "JOIN author a ON ar.author_id = a.id " +
                "WHERE ar.title = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, articleTitle);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Creator author = new Creator(rs.getInt("id"), rs.getString("name"));
                return new Artifact(rs.getString("title"), rs.getString("text"), author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Artifact article = getArticleWithAuthor("Java Basics");
        System.out.println(article);
    }
}