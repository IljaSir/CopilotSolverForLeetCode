class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        int ans = INT_MAX;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = min(ans, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};