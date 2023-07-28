class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n1 = nums1.size(), n2 = nums2.size();
        long long sum1 = accumulate(nums1.begin(), nums1.end(), 0), sum2 = accumulate(nums2.begin(), nums2.end(), 0);
        long long diff = sum2 - sum1;
        if (diff < 0) diff = -diff;
        if (diff < k) return -1;
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        vector<long long> arr1(n1), arr2(n2);
        for (int i = 0; i < n1; i++) arr1[i] = nums1[i];
        for (int i = 0; i < n2; i++) arr2[i] = nums2[i];
        long long ans = 1e18;
        for (int i = 0; i <= k; i++) {
            long long cur = 0;
            if (i > 0) {
                int j = min(n1, i);
                cur += arr1[j - 1] - 1;
            }
            if (k - i > 0) {
                int j = min(n2, k - i);
                cur += arr2[j - 1] - 1;
            }
            if (cur >= diff) {
                ans = min(ans, i);
            }
        }
        return ans;
    }
};