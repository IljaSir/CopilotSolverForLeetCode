class Solution {
public:
    string complexNumberMultiply(string num1, string num2) {
        
        int real1, real2, imag1, imag2;
        int real, imag;
        char c;
        stringstream ss1(num1), ss2(num2);
        ss1 >> real1 >> c >> imag1 >> c;
        ss2 >> real2 >> c >> imag2 >> c;
        real = real1 * real2 - imag1 * imag2;
        imag = real1 * imag2 + real2 * imag1;
        return to_string(real) + "+" + to_string(imag) + "i";
    }
};