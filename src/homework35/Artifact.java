package homework35;

class Artifact {
    private String title;
    private String text;
    private Creator author;



    public Artifact(String title, String text, Creator author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Creator getAuthor() {
        return author;
    }

    public void setAuthor(Creator author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", author=" + author +
                '}';
    }
}