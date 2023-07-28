class Solution {
public:
    vector<int> leftRigthDifference(vector<int>& nums) {
        
        vector<int> leftSum(nums.size(), 0);
        vector<int> rightSum(nums.size(), 0);
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            leftSum[i] = sum;
        }
        sum = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            sum += nums[i];
            rightSum[i] = sum;
        }
        vector<int> result(nums.size(), 0);
        for (int i = 0; i < nums.size(); i++) {
            result[i] = abs(leftSum[i] - rightSum[i]);
        }
        return result;
    }
};