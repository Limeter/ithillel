package homework27;


abstract class BaseStringFilter implements StringFilter {
    protected StringFilter next;

    @Override
    public void setNext(StringFilter next) {
        this.next = next;
    }

    @Override
    public String process(String input) {
        String result = handle(input);
        if (result == null || (next == null)) {
            return result;
        }
        return next.process(result);
    }

    protected abstract String handle(String input);
}