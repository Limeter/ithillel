package homework27;

class MaxLengthFilter extends BaseStringFilter {
    private final int maxLength;

    public MaxLengthFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    protected String handle(String input) {
        return (input != null && input.length() <= maxLength) ? input : null;
    }
}
