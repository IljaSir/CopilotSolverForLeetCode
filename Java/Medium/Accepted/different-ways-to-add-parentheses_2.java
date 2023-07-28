class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i + 1);
                List<Integer> part1Result = diffWaysToCompute(part1);
                List<Integer> part2Result = diffWaysToCompute(part2);
                for (Integer p1 : part1Result) {
                    for (Integer p2 : part2Result) {
                        int r = 0;
                        switch (c) {
                            case '+':
                                r = p1 + p2;
                                break;
                            case '-':
                                r = p1 - p2;
                                break;
                            case '*':
                                r = p1 * p2;
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