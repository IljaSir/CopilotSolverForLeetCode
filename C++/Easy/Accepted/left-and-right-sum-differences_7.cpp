class Solution {
public:
    vector<int> leftRigthDifference(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> leftSum(n, 0);
        vector<int> rightSum(n, 0);
        vector<int> answer(n, 0);
        if (n == 1) return answer;
        leftSum[0] = nums[0];
        rightSum[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i-1] + nums[i];
            rightSum[n-1-i] = rightSum[n-i] + nums[n-1-i];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }
};