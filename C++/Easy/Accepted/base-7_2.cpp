class Solution {
public:
    string convertToBase7(int num) {
        
        if (num == 0) return "0";
        string res;
        bool negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }
        while (num > 0) {
            res = to_string(num % 7) + res;
            num /= 7;
        }
        if (negative) res = "-" + res;
        return res;
    }
};