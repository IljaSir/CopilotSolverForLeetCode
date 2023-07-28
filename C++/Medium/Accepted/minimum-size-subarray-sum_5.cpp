class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int n = nums.size();
        int left = 0, right = 0;
        int sum = 0;
        int result = n + 1;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                result = min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == n + 1 ? 0 : result;
    }
};