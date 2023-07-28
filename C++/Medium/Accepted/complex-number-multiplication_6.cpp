class Solution {
public:
    string complexNumberMultiply(string num1, string num2) {
        
        int a1, a2, b1, b2;
        char sign1, sign2;
        sscanf(num1.c_str(), "%d%c%d", &a1, &sign1, &b1);
        sscanf(num2.c_str(), "%d%c%d", &a2, &sign2, &b2);
        int a = a1 * a2 - b1 * b2;
        int b = a1 * b2 + a2 * b1;
        return to_string(a) + "+" + to_string(b) + "i";
    }
};