class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        vector<int> result;
        int currentSum = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            currentSum += nums[i];
            result.push_back(nums[i]);
            if (currentSum > sum - currentSum) {
                break;
            }
        }
        return result;
    }
};