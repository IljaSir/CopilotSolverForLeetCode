class Solution {
    public int evaluate(String expression) {
        
        return evaluate(expression, new HashMap<String, Integer>());
    }
    private int evaluate(String expression, Map<String, Integer> scope) {
        if (expression.charAt(0) != '(') {
            return isNumber(expression) ? Integer.parseInt(expression) : scope.get(expression);
        }
        List<String> tokens = tokenize(expression.substring(expression.charAt(1) == 'm' ? 6 : 5, expression.length() - 1));
        if (expression.startsWith("(add")) {
            return evaluate(tokens.get(0), scope) + evaluate(tokens.get(1), scope);
        } else if (expression.startsWith("(mult")) {
            return evaluate(tokens.get(0), scope) * evaluate(tokens.get(1), scope);
        } else {
            Map<String, Integer> newScope = new HashMap<String, Integer>(scope);
            for (int i = 0; i < tokens.size() - 1; i += 2) {
                newScope.put(tokens.get(i), evaluate(tokens.get(i + 1), newScope));
            }
            return evaluate(tokens.get(tokens.size() - 1), newScope);
        }
    }
    private List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<String>();
        int balance = 0;
        int prev = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                balance++;
            } else if (expression.charAt(i) == ')') {
                balance--;
            } else if (expression.charAt(i) == ' ' && balance == 0) {
                tokens.add(expression.substring(prev, i));
                prev = i + 1;
            }
        }
        tokens.add(expression.substring(prev, expression.length()));
        return tokens;
    }
    private boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                continue;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}