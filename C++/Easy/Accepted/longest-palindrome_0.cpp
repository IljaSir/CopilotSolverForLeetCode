class Solution {
public:
    int longestPalindrome(string s) {
        
        int cnt[128] = {0};
        for (char c : s) {
            cnt[c]++;
        }
        int ans = 0;
        for (int i = 0; i < 128; ++i) {
            ans += cnt[i] / 2 * 2;
            if (ans % 2 == 0 && cnt[i] % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }
};