class Solution {
public:
    string fractionAddition(string expression) {
        
        int a, b, c, d, g;
        a = b = c = d = g = 0;
        char op = '+';
        for (int i = 0; i < expression.size(); ++i) {
            if (expression[i] == '/' || i == expression.size() - 1) {
                if (op == '+') {
                    a = a * d + b * c;
                    b *= d;
                } else {
                    a = a * d - b * c;
                    b *= d;
                }
                c = 0;
                d = 0;
                op = expression[i];
            } else if (expression[i] == '-') {
                c = 0;
                d = 0;
                op = expression[i];
            } else {
                if (d == 0) {
                    c = c * 10 + expression[i] - '0';
                } else {
                    d = d * 10 + expression[i] - '0';
                }
            }
        }
        g = gcd(a, b);
        a /= g;
        b /= g;
        return to_string(a) + "/" + to_string(b);
    }
};