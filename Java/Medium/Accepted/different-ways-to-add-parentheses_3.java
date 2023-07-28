class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String a = expression.substring(0, i);
                String b = expression.substring(i + 1);
                List<Integer> resultA = diffWaysToCompute(a);
                List<Integer> resultB = diffWaysToCompute(b);
                for (int x : resultA) {
                    for (int y : resultB) {
                        if (c == '+') {
                            result.add(x + y);
                        } else if (c == '-') {
                            result.add(x - y);
                        } else if (c == '*') {
                            result.add(x * y);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(expression));
        }
        return result;
    }
}