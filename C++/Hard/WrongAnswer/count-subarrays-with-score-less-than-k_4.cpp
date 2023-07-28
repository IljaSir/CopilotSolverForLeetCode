class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        int n = nums.size();
        vector<int> pre(n + 1);
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        long long ans = 0;
        for (int i = 1; i <= n; ++i) {
            int l = 0, r = i;
            while (l < r) {
                int mid = (l + r) / 2;
                if (pre[i] - pre[mid] < k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans += i - l;
        }
        return ans;
    }
};