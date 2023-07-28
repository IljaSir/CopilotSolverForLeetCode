class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        
        vector<int> res;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sort(nums.begin(), nums.end());
        int curSum = 0;
        for (int i = nums.size() - 1; i >= 0; --i) {
            curSum += nums[i];
            sum -= nums[i];
            res.push_back(nums[i]);
            if (curSum > sum) {
                break;
            }
        }
        return res;
    }
};