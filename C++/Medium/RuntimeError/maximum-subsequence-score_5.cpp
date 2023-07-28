class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        vector<long long> pre(n + 1);
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + max(nums1[i], nums2[i]);
        }
        long long ans = 0;
        for (int i = 0; i <= k; ++i) {
            int j = k - i;
            if (i > n || j > n) {
                continue;
            }
            ans = max(ans, pre[i] + pre[n] - pre[n - j] + min(nums1[i - 1], nums2[n - j]));
        }
        return ans;
    }
};