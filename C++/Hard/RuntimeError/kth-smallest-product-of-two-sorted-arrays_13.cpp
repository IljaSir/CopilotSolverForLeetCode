class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
        long long n = nums1.size();
        long long m = nums2.size();
        if (n * m < k) {
            return -1;
        }
        if (nums1[0] * nums2[0] > nums1[n - 1] * nums2[m - 1]) {
            swap(nums1, nums2);
            swap(n, m);
        }
        long long left = nums1[0] * nums2[0];
        long long right = nums1[n - 1] * nums2[m - 1];
        while (left < right) {
            long long mid = left + (right - left) / 2;
            long long cnt = 0;
            for (int i = 0; i < n; ++i) {
                int j = upper_bound(nums2.begin(), nums2.end(), mid / nums1[i]) - nums2.begin();
                cnt += j;
            }
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
};