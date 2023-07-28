class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> pre(n, 0);
        for (int i = 0; i < n; ++i) {
            pre[i] = nums[i];
            if (i > 0) pre[i] = min(pre[i], pre[i - 1]);
            if (i > 1) pre[i] = min(pre[i], pre[i - 2]);
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == pre[i - 1]) continue;
            if (i > 1 && nums[i] == pre[i - 2]) continue;
            ans += nums[i];
        }
        return ans;
    }
};