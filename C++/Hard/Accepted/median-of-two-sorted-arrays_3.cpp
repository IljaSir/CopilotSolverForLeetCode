class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int m = nums2.size();
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = n;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (n + m + 1) / 2 - i;
            if (i < n && nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = max(nums1[i - 1], nums2[j - 1]);
                }
                if ((n + m) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == n) {
                    minRight = nums2[j];
                } else if (j == m) {
                    minRight = nums1[i];
                } else {
                    minRight = min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
};