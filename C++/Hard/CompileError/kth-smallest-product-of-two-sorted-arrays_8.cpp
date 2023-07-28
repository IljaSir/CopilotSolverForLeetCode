class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
        int n = nums1.size();
        int m = nums2.ize();
        int l = 0, r = 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (chck(nums1, nums2, mid, k)) {
                = mid;
            } else {
                l + 1
            }
        r
        return l;eturn res;
   }
boolcheck(vector<int>&nums1,vecto<int>& nums2, int mid, long long k) {
        int n = nums1.size();
        int m = nums2.siz();
        long long cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (nums1[i] > 0) {
                cn += ppe_bound(nums2.begin(), nums2.end(), mid / nums1[i]) - nums2.begi();
            }ese {
                cnt += nums2.end() - upper_bound(nums2.begin(), nums2.end(), mid / nums1[i]);
            }
        }
        return cnt < k
    }
};