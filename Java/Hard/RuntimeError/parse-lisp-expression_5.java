class Solution {
    public int evaluate(String expression) {
        
        return evaluate(expression, new HashMap<>());
    }
    public int evaluate(String expression, Map<String, Integer> parentScope) {
        if (expression.charAt(0) != '(') {
            // number or variable
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.parseInt(expression);
            }
            return parentScope.get(expression);
        }
        Map<String, Integer> scope = new HashMap<>(parentScope);
        int start = expression.charAt(1) == 'm' ? 6 : 5;
        int i = start;
        List<String> tokens = new ArrayList<>();
        while (i < expression.length() - 1) {
            if (expression.charAt(i) == '(') {
                int j = i + 1;
                int count = 1;
                while (count > 0) {
                    if (expression.charAt(j) == '(') {
                        count++;
                    } else if (expression.charAt(j) == ')') {
                        count--;
                    }
                    j++;
                }
                tokens.add(expression.substring(i, j));
                i = j;
            } else {
                int j = i + 1;
                while (j < expression.length() && expression.charAt(j) != ' ') {
                    j++;
                }
                tokens.add(expression.substring(i, j));
                i = j;
            }
            while (i < expression.length() - 1 && expression.charAt(i) == ' ') {
                i++;
            }
        }
        if (expression.charAt(1) == 'm') {
            // mult
            return evaluate(tokens.get(0), scope) * evaluate(tokens.get(1), scope);
        } else if (expression.charAt(1) == 'a') {
            // add
            return evaluate(tokens.get(0), scope) + evaluate(tokens.get(1), scope);
        } else {
            // let
            for (int j = 0; j < tokens.size() - 2; j += 2) {
                scope.put(tokens.get(j), evaluate(tokens.get(j + 1), scope));
            }
            return evaluate(tokens.get(tokens.size() - 1), scope);
        }
    }
}