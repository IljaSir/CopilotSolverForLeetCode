class Solution {
public:
    int maxNumOfMarkedIndices(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> cnt(n);
        for (int i = 0; i < n; ++i) {
            int t = upper_bound(nums.begin(), nums.end(), nums[i] * 2) - nums.begin();
            cnt[t - 1]++;
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            ans += cnt[i];
            cnt[i] = ans;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (cnt[i] > i + 1) {
                res = max(res, i + 1);
            }
        }
        return res;
    }
};