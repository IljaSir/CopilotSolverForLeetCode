class Solution {
    public int evaluate(String expression) {
        
        return evaluate(expression, new HashMap<>());
    }

    private int evaluate(String expression, Map<String, Integer> map) {
        if (expression.startsWith("(")) {
            String[] tokens = expression.substring(1, expression.length() - 1).split(" ");
            if (tokens[0].equals("let")) {
                Map<String, Integer> newMap = new HashMap<>(map);
                for (int i = 1; i < tokens.length - 2; i += 2) {
                    newMap.put(tokens[i], evaluate(tokens[i + 1], newMap));
                }
                return evaluate(tokens[tokens.length - 1], newMap);
            } else if (tokens[0].equals("add")) {
                return evaluate(tokens[1], map) + evaluate(tokens[2], map);
            } else {
                return evaluate(tokens[1], map) * evaluate(tokens[2], map);
            }
        } else {
            return map.containsKey(expression) ? map.get(expression) : Integer.parseInt(expression);
        }
    }
}