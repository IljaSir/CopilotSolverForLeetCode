class Solution {
public:
    string numberToWords(int num) {
        
        if (num == 0) return "Zero";
        string ans = "";
        int i = 0;
        while (num) {
            if (num % 1000) ans = helper(num % 1000) + thousands[i] + (ans == "" ? "" : " ") + ans;
            num /= 1000;
            i++;
        }
        return ans;
    }
};