class Solution {
public:
    string complexNumberMultiply(string num1, string num2) {
        
        int a = 0, b = 0, c = 0, d = 0;
        int i = 0;
        while (num1[i] != '+') {
            a = a * 10 + num1[i] - '0';
            i++;
        }
        i++;
        while (num1[i] != 'i') {
            b = b * 10 + num1[i] - '0';
            i++;
        }
        i = 0;
        while (num2[i] != '+') {
            c = c * 10 + num2[i] - '0';
            i++;
        }
        i++;
        while (num2[i] != 'i') {
            d = d * 10 + num2[i] - '0';
            i++;
        }
        int real = a * c - b * d;
        int imag = a * d + b * c;
        return to_string(real) + "+" + to_string(imag) + "i";
    }
};