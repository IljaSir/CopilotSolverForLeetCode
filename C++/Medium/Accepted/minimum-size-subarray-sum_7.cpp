class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        int left = 0, right = 0;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                int length = right - left + 1;
                if (ans == 0 || length < ans) {
                    ans = length;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans;
    }
};