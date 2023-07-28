class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        
        int sum = 0;
        int min = 101;
        int minIdx = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            sum += nums[i];
        }
        if (k == 0) return sum;
        if (nums[minIdx] < 0) {
            nums[minIdx] = -nums[minIdx];
            return largestSumAfterKNegations(nums, k-1);
        } else {
            if (k % 2 == 0) return sum;
            else {
                if (sum - 2*min < 0) return sum - 2*min;
                else return sum;
            }
        }
    }
};