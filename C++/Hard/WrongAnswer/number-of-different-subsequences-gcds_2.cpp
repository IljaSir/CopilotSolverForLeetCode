class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        
        int n = *max_element(nums.begin(), nums.end());
        vector<int> cnt(n + 1);
        for (int x: nums) {
            cnt[x]++;
        }
        vector<int> dp(n + 1);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i]) {
                ans++;
            }
            for (int j = 2 * i; j <= n; j += i) {
                if (cnt[j]) {
                    ans += !dp[i];
                }
                dp[j] = __gcd(dp[j], i);
            }
        }
        return ans;
    }
};