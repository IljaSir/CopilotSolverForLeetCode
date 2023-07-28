class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            ans += nums[i];
        }
        int cur = ans;
        for (int i = 0; i < n - k; i += 2) {
            cur -= nums[i];
            cur += nums[i + k];
            ans = min(ans, cur);
        }
        return ans;
    }
};