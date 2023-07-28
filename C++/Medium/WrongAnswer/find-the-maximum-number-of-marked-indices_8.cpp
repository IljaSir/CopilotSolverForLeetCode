class Solution {
public:
    int maxNumOfMarkedIndices(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> cnt(n, 0);
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            int k = lower_bound(nums.begin(), nums.end(), 2 * x) - nums.begin();
            cnt[k - 1]++;
        }
        for (int i = n - 2; i >= 0; --i) {
            cnt[i] += cnt[i + 1];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res = max(res, min(cnt[i], i + 1));
        }
        return res;
    }
};