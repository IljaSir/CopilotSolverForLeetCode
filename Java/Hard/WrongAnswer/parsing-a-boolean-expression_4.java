class Solution {
    public boolean parseBoolExpr(String expression) {
        
        return parseBoolExpr(expression.toCharArray(), 0, expression.length() - 1);
    }
    
    private boolean parseBoolExpr(char[] expression, int start, int end) {
        if (start == end) {
            return expression[start] == 't';
        }
        if (expression[start] == '!') {
            return !parseBoolExpr(expression, start + 2, end - 1);
        }
        boolean result = expression[start] == '&';
        int i = start + 2;
        while (i < end) {
            int j = i;
            int count = 1;
            while (count > 0) {
                if (expression[j] == '(') {
                    count++;
                } else if (expression[j] == ')') {
                    count--;
                }
                j++;
            }
            boolean value = parseBoolExpr(expression, i, j - 1);
            if (expression[start] == '&') {
                result &= value;
            } else {
                result |= value;
            }
            i = j + 1;
        }
        return result;
    }
}