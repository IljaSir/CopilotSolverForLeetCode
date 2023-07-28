class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int i = 0;
        while (k > 0 && i < n) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
                i++;
            } else {
                break;
            }
        }
        sort(nums.begin(), nums.end());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (k == 0) return sum;
        if (k % 2 == 0) return sum;
        return sum - 2 * nums[0];
    }
};