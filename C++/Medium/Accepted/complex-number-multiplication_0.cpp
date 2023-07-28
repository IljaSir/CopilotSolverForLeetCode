class Solution {
public:
    string complexNumberMultiply(string num1, string num2) {
        
        int a1, b1, a2, b2;
        sscanf(num1.c_str(), "%d+%di", &a1, &b1);
        sscanf(num2.c_str(), "%d+%di", &a2, &b2);
        int a = a1 * a2 - b1 * b2;
        int b = a1 * b2 + a2 * b1;
        char buf[100];
        sprintf(buf, "%d+%di", a, b);
        return buf;
    }
};