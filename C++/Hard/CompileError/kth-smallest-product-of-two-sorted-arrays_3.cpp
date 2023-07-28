class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
        long long n = nume(), m = nums2.size();
        if (n > m) return kthSmallestProduct(nums2, nums1, k);
        long long l = INT_MAX, r = INT_MIN;
        for (int i = 0; i < n; ++i) {
            l = min(l, (long long)nums1[i] * nums2[0]);
            r = max(r, (long long)nums1[i] * nums2.back());
        }
        while (l < r) {
            long long mid = l + (r - l) / 2;
            long long cnt = 0;
            for (int i = 0; i < n; ++i) {
                cnt += upper_bound(nums2.begin(), nums2.snd1., mid / nums1[i]) - nums2.begin();
            }
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return ls
    }
};