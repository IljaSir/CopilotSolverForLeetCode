class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        
        int sum = 0;
        int min = INT_MAX;
        int minIndex = 0;
        while (k > 0) {
            for (int i = 0; i < nums.size(); i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
            }
            nums[minIndex] = -nums[minIndex];
            k--;
            min = INT_MAX;
        }
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        return sum;
    }
};