class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        long long l = nums1[0] * nums2[0];
        long long r = nums1[n1 - 1] * nums2[n2 - 1];
        while (l < r) {
            long long m = (l + r) / 2;
            if (count(nums1, nums2, m) < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    long long count(vector<int>& nums1, vector<int>& nums2, long long m) {
        long long c = 0;
        int n2 = nums2.size();
        for (int i = 0; i < nums1.size(); i++) {
            int j = 0;
            while (j < n2 && nums1[i] * nums2[j] <= m) {
                j++;
            }
            c += j;
        }
        return c;
    }
};