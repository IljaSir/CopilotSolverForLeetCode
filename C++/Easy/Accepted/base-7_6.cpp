class Solution {
public:
    string convertToBase7(int num) {
        
        if (num == 0) return "0";
        string ans = "";
        int sign = num < 0 ? -1 : 1;
        num *= sign;
        while (num > 0) {
            ans = to_string(num % 7) + ans;
            num /= 7;
        }
        if (sign == -1) ans = "-" + ans;
        return ans;
    }
};