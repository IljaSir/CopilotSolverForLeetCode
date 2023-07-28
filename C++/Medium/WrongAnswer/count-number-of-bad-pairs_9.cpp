class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        int n = nums.size();
        int64_t res = 0;
        for (int i = 0; i < n; i++) {
            int64_t x = nums[i] - i;
            auto it = lower_bound(nums.begin(), nums.end(), x);
            if (it != nums.end()) {
                res += (nums.end() - it);
            }
        }
        return res;
    }
};