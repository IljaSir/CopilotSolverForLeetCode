class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(n + 1);
        int tot = 0;
        long long ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; ++i) {
            tot += nums[i] & 1;
            if (tot >= k) {
                ans += cnt[tot - k];
            }
            ++cnt[tot];
        }
        return ans;
    }
};