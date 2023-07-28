class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        int max_sum = -1;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (sum_of_digits(nums[i]) == sum_of_digits(nums[j])) {
                    max_sum = max(max_sum, nums[i] + nums[j]);
                }
            }
        }
        return max_sum;
    }
    int sum_of_digits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
};