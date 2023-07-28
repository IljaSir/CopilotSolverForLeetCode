class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        
        List<Integer> res = new ArrayList<>();
        if(expression == null || expression.length() == 0) return res;
        int len = expression.length();
        for(int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for(int l : left) {
                    for(int r : right) {
                        if(c == '+') {
                            res.add(l + r);
                        } else if(c == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        if(res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}