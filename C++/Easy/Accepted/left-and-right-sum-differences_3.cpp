class Solution {
public:
    vector<int> leftRigthDifference(vector<int>& nums) {
        
        vector<int> leftSum(nums.size());
        vector<int> rightSum(nums.size());
        vector<int> answer(nums.size());
        leftSum[0] = 0;
        for(int i = 1; i < nums.size(); i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        rightSum[nums.size() - 1] = 0;
        for(int i = nums.size() - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        for(int i = 0; i < nums.size(); i++) {
            answer[i] = abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }
};