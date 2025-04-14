package homework37;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sollicitudin lectus dui, eu pretium quam feugiat a. " +
                "Duis sollicitudin eu tortor at ornare. Suspendisse mollis vulputate purus vel imperdiet. Pellentesque in dictum velit, " +
                "ac ultrices augue. Phasellus eu nulla dolor. Fusce non malesuada nisl. Duis sit amet nulla ac ipsum ultricies malesuada " +
                "interdum pellentesque justo. Nulla venenatis turpis sit amet purus tempus faucibus. Duis quis mi mi. Praesent a ultricies " +
                "tellus. Nulla facilisi. Praesent posuere lorem nec mauris aliquam, quis aliquam nibh sodales. Pellentesque ornare egestas " +
                "risus, sed efficitur augue scelerisque quis. Vestibulum a massa risus";

        String[] words = text.toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z\\s]", "")
                .split("\\s+");

        // 1 - Кількість слів більше 3 символів
        long wordCount = Arrays.stream(words)
                .filter(word -> word.length() > 3)
                .count();

        // 2 - Кількість унікальних слів
        long uniqueWordCount = Arrays.stream(words)
                .filter(word -> word.length() > 3)
                .distinct()
                .count();

        // 3 - Кількість повторів слова "duis"
        long duisCount = Arrays.stream(words)
                .filter(word -> word.equals("duis"))
                .count();

        System.out.println("Кількість слів (>3 символів): " + wordCount);
        System.out.println("Кількість унікальних слів: " + uniqueWordCount);
        System.out.println("Слово 'duis' зустрічається: " + duisCount + " раз(и)");
    }
}
