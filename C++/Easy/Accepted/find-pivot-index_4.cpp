class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
};