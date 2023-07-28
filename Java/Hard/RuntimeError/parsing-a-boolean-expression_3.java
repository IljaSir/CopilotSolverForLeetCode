class Solution {
    public boolean parseBoolExpr(String expression) {
        
        return parseBoolExpr(expression, 0, expression.length() - 1);
    }
    
    private boolean parseBoolExpr(String expression, int start, int end) {
        char c = expression.charAt(start);
        if (c == 't') {
            return true;
        } else if (c == 'f') {
            return false;
        } else if (c == '!') {
            return !parseBoolExpr(expression, start + 2, end - 1);
        } else if (c == '&') {
            for (int i = start + 2; i < end; i++) {
                if (expression.charAt(i) == ',') {
                    continue;
                }
                int j = i;
                int count = 0;
                while (count > 0 || expression.charAt(j) != ',') {
                    if (expression.charAt(j) == '(') {
                        count++;
                    } else if (expression.charAt(j) == ')') {
                        count--;
                    }
                    j++;
                }
                if (!parseBoolExpr(expression, i, j - 1)) {
                    return false;
                }
                i = j;
            }
            return true;
        } else {
            for (int i = start + 2; i < end; i++) {
                if (expression.charAt(i) == ',') {
                    continue;
                }
                int j = i;
                int count = 0;
                while (count > 0 || expression.charAt(j) != ',') {
                    if (expression.charAt(j) == '(') {
                        count++;
                    } else if (expression.charAt(j) == ')') {
                        count--;
                    }
                    j++;
                }
                if (parseBoolExpr(expression, i, j - 1)) {
                    return true;
                }
                i = j;
            }
            return false;
        }
    }
}