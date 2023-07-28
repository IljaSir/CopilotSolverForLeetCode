class Solution {
    public int evaluate(String expression) {
        
        return evaluate(expression, new HashMap<>());
    }

    private int evaluate(String expression, Map<String, Integer> map) {
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-')
                return Integer.parseInt(expression);
            return map.get(expression);
        }
        List<String> tokens = parse(expression.substring(expression.charAt(1) == 'm' ? 6 : 5, expression.length() - 1));
        Map<String, Integer> newMap = new HashMap<>(map);
        if (expression.startsWith("(let")) {
            for (int i = 0; i < tokens.size() - 2; i += 2)
                newMap.put(tokens.get(i), evaluate(tokens.get(i + 1), newMap));
            return evaluate(tokens.get(tokens.size() - 1), newMap);
        }
        int ans = evaluate(tokens.get(0), newMap);
        for (int i = 1; i < tokens.size(); i++)
            ans += expression.startsWith("(add") ? evaluate(tokens.get(i), newMap) : ans * evaluate(tokens.get(i), newMap);
        return ans;
    }

    private List<String> parse(String s) {
        List<String> res = new ArrayList<>();
        int i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == '(') {
                int count = 1;
                while (count > 0) {
                    i++;
                    if (s.charAt(i) == '(')
                        count++;
                    else if (s.charAt(i) == ')')
                        count--;
                }
                res.add(s.substring(i - count + 1, i + 1));
            } else {
                int j = i + 1;
                while (j < n && s.charAt(j) != ' ')
                    j++;
                res.add(s.substring(i, j));
                i = j;
            }
            i++;
        }
        return res;
    }
}