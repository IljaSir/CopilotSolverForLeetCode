class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i + 1);
                List<Integer> result1 = diffWaysToCompute(part1);
                List<Integer> result2 = diffWaysToCompute(part2);
                for (Integer r1 : result1) {
                    for (Integer r2 : result2) {
                        int r = 0;
                        switch (c) {
                            case '+':
                                r = r1 + r2;
                                break;
                            case '-':
                                r = r1 - r2;
                                break;
                            case '*':
                                r = r1 * r2;
                                break;
                        }
                        result.add(r);
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