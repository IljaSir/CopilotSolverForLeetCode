class Solution {
public:
    int longestPalindrome(string s) {
        
        unordered_map<char, int> cnt;
        for (auto c : s) {
            cnt[c]++;
        }
        int ans = 0;
        for (auto [c, n] : cnt) {
            ans += n / 2 * 2;
            if (ans % 2 == 0 && n % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }
};