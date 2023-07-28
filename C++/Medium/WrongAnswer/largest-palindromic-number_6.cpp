class Solution {
public:
    string largestPalindromic(string num) {
        
        string ans;
        string ans1;
        for (int i = num.size()-1; i >= 0; --i) {
            ans += num[i];
            ans1 += num[i];
            if (ans == ans1) {
                return ans;
            }
        }
        return ans;
    }
};