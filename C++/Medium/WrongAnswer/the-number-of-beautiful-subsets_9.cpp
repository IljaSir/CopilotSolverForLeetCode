class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int max_num = 0;
            int min_num = 1000;
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) {
                    max_num = max(max_num, nums[i]);
                    min_num = min(min_num, nums[i]);
                }
            }
            if (max_num - min_num >= k) {
                ans++;
            }
        }
        return ans;
    }
};