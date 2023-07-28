class Solution {
public:
    string fractionAddition(string expression) {
        
        int a = 0, b = 1, c, d;
        char op;
        stringstream ss(expression);
        while (ss >> op >> c >> d) {
            a = a * d + (op == '-' ? -1 : 1) * b * c;
            b *= d;
            int g = abs(__gcd(a, b));
            a /= g;
            b /= g;
        }
        return to_string(a) + '/' + to_string(b);
    }
};