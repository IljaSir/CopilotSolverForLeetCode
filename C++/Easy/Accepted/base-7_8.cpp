class Solution {
public:
    string convertToBase7(int num) {
        
        string str;
        bool isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        do {
            str.push_back('0' + num % 7);
            num /= 7;
        } while (num > 0);
        if (isNegative) {
            str.push_back('-');
        }
        reverse(str.begin(), str.end());
        return str;
    }
};