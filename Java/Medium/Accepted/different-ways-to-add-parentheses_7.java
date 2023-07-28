class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                List<Integer> leftRes = diffWaysToCompute(left);
                List<Integer> rightRes = diffWaysToCompute(right);
                for (int l : leftRes) {
                    for (int r : rightRes) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}