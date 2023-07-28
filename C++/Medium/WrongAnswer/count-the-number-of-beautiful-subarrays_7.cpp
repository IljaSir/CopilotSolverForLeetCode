class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        
        long long ans = 0;
        int n = nums.size();
        vector<int> pre(n+1);
        for (int i = 0; i < n; ++i) {
            pre[i+1] = pre[i] + (nums[i] & 1);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j <= n; ++j) {
                if ((pre[j] - pre[i]) & 1) {
                    ++ans;
                }
            }
        }
        return ans;
    }
};