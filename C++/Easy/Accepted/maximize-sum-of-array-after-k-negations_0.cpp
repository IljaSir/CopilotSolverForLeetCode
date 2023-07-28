class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        
        int sum = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        if (k > 0 && k % 2 != 0) {
            sort(nums.begin(), nums.end());
            sum -= 2 * nums[0];
        }
        return sum;
    }
};