package homework27;

public class Chain {
    public static void main(String[] args) {
        StringFilter minLengthFilter = new MinLengthFilter(5);
        StringFilter maxLengthFilter = new MaxLengthFilter(20);
        StringFilter trimFilter = new TrimFilter();

        minLengthFilter.setNext(maxLengthFilter);
        maxLengthFilter.setNext(trimFilter);

        // Демонстрация превышенного лимита максимальных символов
        String inputMax = "   Hello world, my name is:  ";
        String resultMax = minLengthFilter.process(inputMax);

        System.out.println("Вход: |" + inputMax + "|");
        System.out.println("Обработано: |" + resultMax + "|");
        System.out.println("");

        // Демонстрация превышенного лимита минимальных символов
        String inputMin = "   Hi!   ";
        String resultMin = minLengthFilter.process(inputMin);

        System.out.println("Вход: |" + inputMin + "|");
        System.out.println("Обработано: |" + resultMin + "|");
        System.out.println("");
        
        // Демонстрация работоспособности
        String inputDefault = "   Hello World!   ";
        String resultDefault = minLengthFilter.process(inputDefault);

        System.out.println("Вход: |" + inputDefault + "|");
        System.out.println("Обработано: |" + resultDefault + "|");
    }
}