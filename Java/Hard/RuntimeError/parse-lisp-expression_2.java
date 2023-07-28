class Solution {
    public int evaluate(String expression) {
        
        return evaluate(expression, new HashMap<String, Integer>());
    }
    private int evaluate(String expression, Map<String, Integer> parent) {
        Map<String, Integer> map = new HashMap<String, Integer>(parent);
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.parseInt(expression);
            }
            return map.get(expression);
        }
        int i = 0;
        List<String> tokens = new ArrayList<String>();
        while (i < expression.length()) {
            if (expression.charAt(i) == '(') {
                int j = i + 1, count = 1;
                while (count > 0) {
                    if (expression.charAt(j) == '(') {
                        count++;
                    } else if (expression.charAt(j) == ')') {
                        count--;
                    }
                    j++;
                }
                tokens.add(evaluate(expression.substring(i, j), map) + "");
                i = j - 1;
            } else if (expression.charAt(i) != ' ') {
                int j = i + 1;
                while (j < expression.length() && expression.charAt(j) != ' ') {
                    j++;
                }
                tokens.add(expression.substring(i, j));
                i = j - 1;
            }
            i++;
        }
        if (tokens.get(0).equals("add")) {
            return Integer.parseInt(tokens.get(1)) + Integer.parseInt(tokens.get(2));
        } else if (tokens.get(0).equals("mult")) {
            return Integer.parseInt(tokens.get(1)) * Integer.parseInt(tokens.get(2));
        } else {
            for (int j = 1; j < tokens.size() - 1; j += 2) {
                map.put(tokens.get(j), Integer.parseInt(tokens.get(j + 1)));
            }
            return Integer.parseInt(tokens.get(tokens.size() - 1));
        }
    }
}