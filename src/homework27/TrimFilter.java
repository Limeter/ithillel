package homework27;


public class TrimFilter extends BaseStringFilter {
    @Override
    protected String handle(String input) {
        return input != null ? input.trim() : null;
    }
}