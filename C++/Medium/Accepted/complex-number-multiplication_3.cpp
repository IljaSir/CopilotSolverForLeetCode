class Solution {
public:
    string complexNumberMultiply(string num1, string num2) {
        
        int i1 = num1.find('+');
        int i2 = num2.find('+');
        int r1 = stoi(num1.substr(0, i1));
        int r2 = stoi(num2.substr(0, i2));
        int i1_ = stoi(num1.substr(i1 + 1, num1.size() - i1 - 2));
        int i2_ = stoi(num2.substr(i2 + 1, num2.size() - i2 - 2));
        int r = r1 * r2 - i1_ * i2_;
        int i = r1 * i2_ + r2 * i1_;
        return to_string(r) + "+" + to_string(i) + "i";
    }
};