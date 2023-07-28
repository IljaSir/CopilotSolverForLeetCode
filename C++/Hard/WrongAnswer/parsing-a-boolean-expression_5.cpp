class Solution {
public:
    bool parseBoolExpr(string expression) {
        
        return parse(expression);
    }
    
    bool parse(string expr) {
        if (expr == "t") return true;
        if (expr == "f") return false;
        if (expr[0] == '!') return !parse(expr.substr(2, expr.size()-3));
        if (expr[0] == '&') {
            int i = 2;
            bool res = true;
            while (i < expr.size()) {
                int j = i;
                int cnt = 0;
                while (j < expr.size()) {
                    if (expr[j] == '(') cnt++;
                    if (expr[j] == ')') cnt--;
                    if (cnt == 0) break;
                    j++;
                }
                res = res && parse(expr.substr(i, j-i+1));
                i = j+2;
            }
            return res;
        }
        if (expr[0] == '|') {
            int i = 2;
            bool res = false;
            while (i < expr.size()) {
                int j = i;
                int cnt = 0;
                while (j < expr.size()) {
                    if (expr[j] == '(') cnt++;
                    if (expr[j] == ')') cnt--;
                    if (cnt == 0) break;
                    j++;
                }
                res = res || parse(expr.substr(i, j-i+1));
                i = j+2;
            }
            return res;
        }
        return false;
    }
};