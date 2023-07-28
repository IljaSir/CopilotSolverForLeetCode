class Solution {
public:
    string complexNumberMultiply(string num1, string num2) {
        
        int real1 = 0, real2 = 0, imaginary1 = 0, imaginary2 = 0;
        int pos = 0;
        for (int i = 0; i < num1.size(); i++) {
            if (num1[i] == '+') {
                real1 = stoi(num1.substr(0, i));
                pos = i + 1;
            }
            if (num1[i] == 'i') {
                imaginary1 = stoi(num1.substr(pos, i - pos));
            }
        }
        for (int i = 0; i < num2.size(); i++) {
            if (num2[i] == '+') {
                real2 = stoi(num2.substr(0, i));
                pos = i + 1;
            }
            if (num2[i] == 'i') {
                imaginary2 = stoi(num2.substr(pos, i - pos));
            }
        }
        int real = real1 * real2 - imaginary1 * imaginary2;
        int imaginary = real1 * imaginary2 + real2 * imaginary1;
        return to_string(real) + "+" + to_string(imaginary) + "i";
    }
};