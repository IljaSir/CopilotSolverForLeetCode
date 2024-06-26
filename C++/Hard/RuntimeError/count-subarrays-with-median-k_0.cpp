class Solution {
public:
    int countSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> pre(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + (nums[i] < k ? -1 : 1);
        }
        unordered_map<int, int> cnt;
        int ans = 0;
        for (int i = 0; i <= n; ++i) {
            ans += cnt[pre[i]];
            ++cnt[pre[i + 1]];
        }
        return ans;
    }
};