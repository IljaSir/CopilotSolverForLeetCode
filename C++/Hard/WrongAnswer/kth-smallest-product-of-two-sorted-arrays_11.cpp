class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
        int n = nums1.size(), m = nums2.size();
        if (n > m) return kthSmallestProduct(nums2, nums1, k);
        if (nums1.back() * nums2.front() >= nums1.front() * nums2.back()) {
            swap(nums1, nums2);
            swap(n, m);
        }
        long long l = nums1.front() * nums2.front(), r = nums1.back() * nums2.back();
        while (l < r) {
            long long mid = l + (r - l) / 2;
            long long cnt = 0;
            for (int i = 0; i < n; ++i) {
                cnt += upper_bound(nums2.begin(), nums2.end(), mid / nums1[i]) - nums2.begin();
            }
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
};