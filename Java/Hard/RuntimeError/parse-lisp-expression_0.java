class Solution {
    public int evaluate(String expression) {
        
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        return evaluate(expression, stack);
    }
    
    private int evaluate(String expression, Stack<Map<String, Integer>> stack) {
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.parseInt(expression);
            }
            for (int i = stack.size() - 1; i >= 0; i--) {
                if (stack.get(i).containsKey(expression)) {
                    return stack.get(i).get(expression);
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        int start = expression.charAt(1) == 'm' ? 6 : 5;
        int count = 0;
        for (int i = start; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count == 0 && (c == ' ' || i == expression.length() - 1)) {
                int val = evaluate(expression.substring(start, i), stack);
                if (expression.charAt(1) == 'a') {
                    map.put("a", map.getOrDefault("a", 0) + val);
                } else if (expression.charAt(1) == 'm') {
                    map.put("m", map.getOrDefault("m", 1) * val);
                } else {
                    map.put(expression.substring(start - 1, start), val);
                }
                start = i + 2;
            }
        }
        if (map.containsKey("a")) {
            return map.get("a");
        }
        if (map.containsKey("m")) {
            return map.get("m");
        }
        stack.push(map);
        int val = evaluate(expression.substring(start, expression.length() - 1), stack);
        stack.pop();
        return val;
    }
}