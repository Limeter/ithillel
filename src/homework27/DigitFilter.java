package homework27;

class DigitFilter extends BaseStringFilter {
    @Override
    protected String handle(String input) {
        return input.replaceAll("\\d", "");
    }
}
