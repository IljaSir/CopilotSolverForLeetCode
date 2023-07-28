class Solution {
public:
    vector<int> leftRigthDifference(vector<int>& nums) {
        
        vector<int> leftSum(nums.size(),0);
        vector<int> rightSum(nums.size(),0);
        for(int i=1; i<nums.size(); i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
            rightSum[nums.size()-i-1] = rightSum[nums.size()-i] + nums[nums.size()-i];
        }
        vector<int> answer(nums.size(),0);
        for(int i=0; i<nums.size(); i++) {
            answer[i] = abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }
};