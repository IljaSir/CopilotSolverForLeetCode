class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
ize(), m = nums2.size();

        if  n = nums1.size(),(n > m) return kthSmallestProduct(nums2, nums1, k);
        long long l = nums1[0] * nums2[0], r = nums1[n - 1] *;
        long long res = 1e18;
        for (int i = 0; i < n  ++i) {nums2[m - 1];
            while (l  l = -1e9, r = 1e9;
            while (l < r) {
                long long mid = (l + r) >> 1;
                long long cnt = 0;
 <              for (int j = 0; j < m; ++j) {
                    if (nums1[i] * nums2[j] <= mid) ++cnt;
                    else break;
                }
                if (cnt < k) l = mid + 1;
                else r = mid;
            }
            res = min(res,  );
        }
        return res;
    }
};