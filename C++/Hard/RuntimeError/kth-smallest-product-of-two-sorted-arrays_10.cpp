class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
        int n = nums1.size();
        int m = nums2.size();
        if (n > m) return kthSmallestProduct(nums2, nums1, k);
        long long left = LLONG_MIN;
        long long right = LLONG_MAX;
        while (left < right) {
            long long mid = left + (right - left) / 2;
            long long cnt = 0;
            for (int i = 0, j = m - 1; i < n; ++i) {
                while (j >= 0 && (long long)nums1[i] * nums2[j] > mid) --j;
                cnt += j + 1;
            }
            if (cnt < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
};