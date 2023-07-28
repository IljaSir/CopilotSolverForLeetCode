class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        
        int odd = 0, res = 0, n = nums.size();
        vector<int> pre(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            odd += nums[i] & 1;
            pre[odd] += 1;
            if (odd >= k) res += pre[odd - k];
        }
        return res;
    }
};