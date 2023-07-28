class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String exp1 = expression.substring(0, i);
                String exp2 = expression.substring(i + 1);
                List<Integer> res1 = diffWaysToCompute(exp1);
                List<Integer> res2 = diffWaysToCompute(exp2);
                for (int r1 : res1) {
                    for (int r2 : res2) {
                        if (c == '+') {
                            res.add(r1 + r2);
                        } else if (c == '-') {
                            res.add(r1 - r2);
                        } else if (c == '*') {
                            res.add(r1 * r2);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}