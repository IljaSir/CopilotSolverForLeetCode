class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
        long long n = nums1.size(), m = nums2.size();
        if (n > m) return kthSmallestProduct(nums2, nums1, k);
        long long l = nums1[0] * nums2[0], r = nums1[n - 1] * nums2[m - 1];
        while (l < r) {
            long long mid = l + (r - l) / 2;
            long long cnt = 0;
            for (int i = 0, j = m - 1; i < n; ++i) {
                while (j >= 0 && (long long)nums1[i] * nums2[j] > mid) --j;
                cnt += j + 1;
            }
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
};