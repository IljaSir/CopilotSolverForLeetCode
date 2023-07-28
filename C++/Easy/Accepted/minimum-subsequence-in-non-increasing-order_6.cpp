class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        
        vector<int> res;
        int cur = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            cur += nums[i];
            res.push_back(nums[i]);
            if (cur > sum - cur) {
                break;
            }
        }
        
        return res;
    }
};