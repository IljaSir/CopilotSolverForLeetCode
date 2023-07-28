class Solution {
public:
    string largestPalindromic(string num) {
        
        string ans = num;
        sort(ans.begin(), ans.end());
        reverse(ans.begin(), ans.end());
        return ans;
    }
};