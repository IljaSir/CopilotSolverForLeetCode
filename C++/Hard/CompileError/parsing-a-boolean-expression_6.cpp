class Solution {
public:
    bool parseBoolExpr(string expression) {
        
        string str;
        for (int i = 0; i < expression.size(); i++) {
            if (expression[i] != ' ') {
                str += expression[i];
            }
        }
        return parseBoolExpr(str);
    }
    bool parseBoolExpr(string expression) {
        if (expression == "t") {
            return true;
        }
        if (expression == "f") {
            return false;
        }
        if (expression[0] == '!') {
            return !parseBoolExpr(expression.substr(2, expression.size() - 3));
        }
        if (expression[0] == '|') {
            int count = 0;
            for (int i = 2; i < expression.size(); i++) {
                if (expression[i] == '(') {
                    count++;
                }
                if (expression[i] == ')') {
                    count--;
                }
                if (expression[i] == ',' && count == 0) {
                    if (parseBoolExpr(expression.substr(2, i - 2)) || parseBoolExpr(expression.substr(i + 1, expression.size() - i - 2))) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (expression[0] == '&') {
            int count = 0;
            for (int i = 2; i < expression.size(); i++) {
                if (expression[i] == '(') {
                    count++;
                }
                if (expression[i] == ')') {
                    count--;
                }
                if (expression[i] == ',' && count == 0) {
                    if (parseBoolExpr(expression.substr(2, i - 2)) && parseBoolExpr(expression.substr(i + 1, expression.size() - i - 2))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
};