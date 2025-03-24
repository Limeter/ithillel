package homework27;

class MinLengthFilter extends BaseStringFilter {
    private final int minLength;

    public MinLengthFilter(int minLength) {
        this.minLength = minLength;
    }

    @Override
    protected String handle(String input) {
        return (input != null && input.length() >= minLength) ? input : null;
    }
}