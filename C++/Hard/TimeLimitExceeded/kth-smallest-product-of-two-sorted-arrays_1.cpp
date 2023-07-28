class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
        long long n = nums1.size(), m = nums2.size();
        if (n > m) return kthSmallestProduct(nums2, nums1, k);
        long long l = nums1[0] * nums2[0], r = nums1.back() * nums2.back();
        while (l < r) {
            long long mid = (l + r) / 2;
            long long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += upper_bound(nums2.begin(), nums2.end(), mid / nums1[i]) - nums2.begin();
            }
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
};