class Solution {
public:
    string fractionAddition(string expression) {
        
        int a = 0, b = 1, c, d;
        char op;
        stringstream ss(expression);
        while(ss >> c >> op >> d) {
            a = a * d + b * c;
            b *= d;
            int g = gcd(a, b);
            a /= g;
            b /= g;
        }
        return to_string(a) + "/" + to_string(b);
    }
};