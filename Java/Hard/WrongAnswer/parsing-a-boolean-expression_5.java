class Solution {
    public boolean parseBoolExpr(String expression) {
        
        return parseBoolExpr(expression.toCharArray(), 0, expression.length() - 1);
    }
    private boolean parseBoolExpr(char[] expression, int start, int end) {
        if (start == end) {
            return expression[start] == 't';
        }
        char op = expression[start + 1];
        if (op == '!') {
            return !parseBoolExpr(expression, start + 2, end - 1);
        }
        int i = start + 2;
        boolean result = op == '&';
        while (i < end) {
            int j = i + 1;
            int count = 0;
            while (j < end) {
                if (expression[j] == '(') {
                    count++;
                } else if (expression[j] == ')') {
                    count--;
                }
                if (count == 0) {
                    break;
                }
                j++;
            }
            boolean subResult = parseBoolExpr(expression, i, j);
            if (op == '&') {
                result &= subResult;
            } else if (op == '|') {
                result |= subResult;
            }
            i = j + 2;
        }
        return result;
    }
}