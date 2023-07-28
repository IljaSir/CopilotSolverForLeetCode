class Solution {
public:
    string minimizeResult(string expression) {
        
        int n = expression.size();
        int a = 0, b = 0;
        int i = 0;
        while (i < n && expression[i] != '+') {
            a = a * 10 + expression[i] - '0';
            i++;
        }
        i++;
        while (i < n) {
            b = b * 10 + expression[i] - '0';
            i++;
        }
        int x = a + b;
        int y = a * b;
        if (x < y) {
            return expression;
        } else if (x == y) {
            return "(" + expression + ")";
        } else {
            return to_string(a) + "(" + to_string(b) + ")";
        }
    }
};