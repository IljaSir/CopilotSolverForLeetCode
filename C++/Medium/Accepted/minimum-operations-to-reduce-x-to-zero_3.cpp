class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return n;
        }
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int maxLength = -1;
        while (right < n) {
            currentSum += nums[right];
            while (currentSum > target) {
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == target) {
                maxLength = max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength == -1 ? -1 : n - maxLength;
    }
};