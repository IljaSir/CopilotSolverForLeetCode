class Solution {
public:
    int longestPalindrome(string s) {
        
        int ans = 0;
        unordered_map<char, int> cnt;
        for (char c : s) {
            cnt[c]++;
            if (cnt[c] % 2 == 0) {
                ans += 2;
            }
        }
        return ans < s.length() ? ans + 1 : ans;
    }
};