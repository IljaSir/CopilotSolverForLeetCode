class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int k = (n1 + n2 + 1) / 2;
        int left = 0, right = n1;
        while (left < right) {
            int m1 = left + (right - left) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]) {
                left = m1 + 1;
            } else {
                right = m1;
            }
        }
        int m1 = left;
        int m2 = k - left;
        int c1 = max(m1 <= 0 ? INT_MIN : nums1[m1 - 1],
                     m2 <= 0 ? INT_MIN : nums2[m2 - 1]);
        if ((n1 + n2) % 2 == 1) {
            return c1;
        }
        int c2 = min(m1 >= n1 ? INT_MAX : nums1[m1],
                     m2 >= n2 ? INT_MAX : nums2[m2]);
        return (c1 + c2) * 0.5;
    }
};