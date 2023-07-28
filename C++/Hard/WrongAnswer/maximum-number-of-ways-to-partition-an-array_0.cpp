class Solution {
public:
    int waysToPartition(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n, 0);
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        unordered_map<int, int> cnt;
        for (int i = 0; i < n; i++) {
            cnt[sum[i]]++;
        }
        for (int i = 0; i < n; i++) {
            ans = max(ans, cnt[sum[i]]);
        }
        for (int i = 0; i < n; i++) {
            int t = sum[i] - nums[i] + k;
            if (cnt.count(t)) {
                ans = max(ans, cnt[t] + (t == sum[i] ? -1 : 0));
            }
        }
        return ans;
    }
};