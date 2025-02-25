package homework27;

interface StringFilter {
    void setNext(StringFilter next);
    String process(String input);
}

