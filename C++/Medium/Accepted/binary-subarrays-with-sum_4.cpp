class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> pre(n+1);
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + nums[i];
        }
        unordered_map<int, int> cnt;
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += cnt[pre[i] - goal];
            cnt[pre[i]]++;
        }
        return ans;
    }
};