class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int m = nums1.size();
        int n = nums2.size();
        int total = m + n;
        if (total & 0x1) {
            return getKth(nums1, 0, m, nums2, 0, n, total / 2 + 1);
        } else {
            return (getKth(nums1, 0, m, nums2, 0, n, total / 2) + getKth(nums1, 0, m, nums2, 0, n, total / 2 + 1)) / 2.0;
        }
    }

    double getKth(vector<int>& nums1, int start1, int len1, vector<int>& nums2, int start2, int len2, int k) {
        if (len1 > len2) {
            return getKth(nums2, start2, len2, nums1, start1, len1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return min(nums1[start1], nums2[start2]);
        }
        int i = start1 + min(len1, k / 2) - 1;
        int j = start2 + min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, len1, nums2, j + 1, len2 - min(len2, k / 2), k - min(len2, k / 2));
        } else {
            return getKth(nums1, i + 1, len1 - min(len1, k / 2), nums2, start2, len2, k - min(len1, k / 2));
        }
    }
};