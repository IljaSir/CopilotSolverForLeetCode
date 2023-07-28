class Solution {
public:
    bool parseBoolExpr(string expression) {
        
        int i = 0;
        return parseBoolExpr(expression, i);
    }
    bool parseBoolExpr(string& expression, int& i) {
        char op = expression[i++];
        if (op == 't') return true;
        if (op == 'f') return false;
        if (op == '!') {
            bool v = parseBoolExpr(expression, i);
            i++;
            return !v;
        }
        vector<bool> v;
        while (i < expression.size()) {
            if (expression[i] == ')') {
                i++;
                break;
            }
            if (expression[i] == ',') {
                i++;
                continue;
            }
            v.push_back(parseBoolExpr(expression, i));
        }
        if (op == '&') {
            for (auto& x: v)
                if (!x) return false;
            return true;
        }
        if (op == '|') {
            for (auto& x: v)
                if (x) return true;
            return false;
        }
        return false;
    }
};