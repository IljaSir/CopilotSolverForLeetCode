class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        
        int n = nums.size();
        vector<int> cnt(n, 0);
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] >= minK && nums[i] <= maxK) {
                cnt[i] = 1;
                if (i > 0) {
                    cnt[i] += cnt[i - 1];
                }
            }
            res += cnt[i];
        }
        return res;
    }
};