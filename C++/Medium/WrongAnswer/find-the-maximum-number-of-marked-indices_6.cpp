class Solution {
public:
    int maxNumOfMarkedIndices(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> cnt(n, 0);
        for (int i = 0; i < n; i++) {
            int idx = lower_bound(nums.begin(), nums.end(), 2 * nums[i]) - nums.begin();
            cnt[i] = idx;
        }
        int ans = 0;
        int maxIdx = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cnt[i] > maxIdx) {
                maxIdx = cnt[i];
                ans++;
            }
        }
        return ans;
    }
};