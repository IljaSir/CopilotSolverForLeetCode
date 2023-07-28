class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        
        int n = nums.size();
        int sum = 0;
        int min = 101;
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        int negCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) negCount++;
        }
        if (k <= negCount) {
            for (int i = 0; i < k; i++) {
                sum -= 2 * nums[i];
            }
        } else {
            sum -= 2 * min;
            k -= negCount;
            if (k % 2 == 1) {
                sum -= 2 * min;
            }
        }
        return sum;
    }
};