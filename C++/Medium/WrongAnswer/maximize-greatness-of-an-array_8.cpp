class Solution {
public:
    int maximizeGreatness(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res = max(res, min(nums[i], i == 0 ? INT_MAX : nums[i - 1]));
        }
        return res;
    }
};