class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        
        for (int i = 0; i < k; ++i) {
            int min = 0;
            for (int j = 1; j < nums.size(); ++j) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            nums[min] = -nums[min];
        }
        
        int sum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            sum += nums[i];
        }
        return sum;
    }
};