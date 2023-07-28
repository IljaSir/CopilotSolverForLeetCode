class Solution {
public:
    string complexNumberMultiply(string num1, string num2) {
        
        int a1 = 0, b1 = 0, a2 = 0, b2 = 0;
        int i = 0;
        while (num1[i] != '+') {
            a1 = a1 * 10 + (num1[i] - '0');
            i++;
        }
        i++;
        while (num1[i] != 'i') {
            b1 = b1 * 10 + (num1[i] - '0');
            i++;
        }
        i = 0;
        while (num2[i] != '+') {
            a2 = a2 * 10 + (num2[i] - '0');
            i++;
        }
        i++;
        while (num2[i] != 'i') {
            b2 = b2 * 10 + (num2[i] - '0');
            i++;
        }
        int a = a1 * a2 - b1 * b2;
        int b = a1 * b2 + b1 * a2;
        string ans = to_string(a) + "+" + to_string(b) + "i";
        return ans;
    }
};