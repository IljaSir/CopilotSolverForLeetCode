class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) return "Zero";
        string res;
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + thousands[i] + (res.empty() ? "" : " ") + res;
            }
            num /= 1000;
            ++i;
        }
        return res;
    }
};