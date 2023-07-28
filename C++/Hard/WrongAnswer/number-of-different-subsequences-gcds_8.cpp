class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        
        int n = nums.size();
        int maxn = 2e5+5;
        vector<int> cnt(maxn, 0);
        for (auto x : nums) {
            cnt[x]++;
        }
        vector<int> dp(maxn, 0);
        for (int i = 1; i < maxn; i++) {
            if (cnt[i]) {
                for (int j = i; j < maxn; j += i) {
                    dp[j] = __gcd(dp[j], i);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < maxn; i++) {
            if (dp[i] == i) {
                ans++;
            }
        }
        return ans;
    }
};