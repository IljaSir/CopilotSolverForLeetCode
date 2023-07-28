class Solution {
public:
    bool parseBoolExpr(string expression) {
        
        return parseBoolExpr(expression, 0, expression.size() - 1);
    }
    
    bool parseBoolExpr(string& expression, int start, int end) {
        if (expression[start] == 't') {
            return true;
        } else if (expression[start] == 'f') {
            return false;
        } else if (expression[start] == '!') {
            return !parseBoolExpr(expression, start + 2, end - 1);
        } else {
            bool result = expression[start] == '&';
            int i = start + 2;
            while (i < end) {
                int j = i + 1;
                int depth = 0;
                while (j <= end) {
                    if (expression[j] == '(') {
                        depth++;
                    } else if (expression[j] == ')') {
                        depth--;
                    }
                    if (depth == 0) {
                        break;
                    }
                    j++;
                }
                bool value = parseBoolExpr(expression, i, j);
                if (expression[start] == '&') {
                    result &= value;
                } else {
                    result |= value;
                }
                i = j + 2;
            }
            return result;
        }
    }
};