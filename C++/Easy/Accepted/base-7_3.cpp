class Solution {
public:
    string convertToBase7(int num) {
        
        if (num == 0) return "0";
        string res = "";
        int sign = num < 0 ? -1 : 1;
        num = abs(num);
        while (num > 0) {
            res = to_string(num % 7) + res;
            num /= 7;
        }
        if (sign == -1) res = "-" + res;
        return res;
    }
};