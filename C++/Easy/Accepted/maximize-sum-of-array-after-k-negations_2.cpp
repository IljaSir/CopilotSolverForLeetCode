class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        
        int n = nums.size();
        int sum = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        if (k == 0) {
            return sum;
        }
        if (k % 2 == 0) {
            return sum;
        }
        sort(nums.begin(), nums.end());
        return sum - 2 * nums[0];
    }
};