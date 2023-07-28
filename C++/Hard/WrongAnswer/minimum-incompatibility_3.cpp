class Solution {
public:
    int minimumIncompatibility(vector<int>& nums, int k) {
        
        int n = nums.size();
        int m = n / k;
        int all = 1 << n;
        vector<int> dp(all, -1);
        dp[0] = 0;
        for (int i = 0; i < all; i++) {
            if (dp[i] == -1) continue;
            vector<int> cnt(n + 1);
            int maxv = 0, minv = n + 1;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    cnt[nums[j]]++;
                    maxv = max(maxv, nums[j]);
                    minv = min(minv, nums[j]);
                }
            }
            if (*max_element(cnt.begin(), cnt.end()) > m) continue;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    dp[i | (1 << j)] = max(dp[i | (1 << j)], dp[i] + (cnt[nums[j]] == 0 ? maxv - minv : 0));
                }
            }
        }
        return dp[all - 1];
    }
};