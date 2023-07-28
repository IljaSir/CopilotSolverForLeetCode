class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        vector<int> sum1(n + 1, 0);
        vector<int> sum2(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum1[i + 1] = sum1[i] + nums1[i];
            sum2[i + 1] = sum2[i] + nums2[i];
        }
        long long res = 0;
        for (int i = 0; i <= k; ++i) {
            int j = k - i;
            if (i > n || j > n) continue;
            int m = min(nums1[i - 1], nums2[n - j]);
            res = max(res, (long long)sum1[i] + (long long)sum2[n] - (long long)sum2[n - j] + (long long)m * j);
        }
        return res;
    }
};