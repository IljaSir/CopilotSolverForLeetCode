class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size() + nums2.size();
        if (n % 2 == 1) {
            return findKth(nums1, nums2, n / 2 + 1);
        } else {
            return (findKth(nums1, nums2, n / 2) + findKth(nums1, nums2, n / 2 + 1)) / 2.0;
        }
    }
    int findKth(vector<int>& nums1, vector<int>& nums2, int k) {
        int m = nums1.size(), n = nums2.size();
        int i = 0, j = 0;
        while (true) {
            if (i == m) {
                return nums2[j + k - 1];
            }
            if (j == n) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return min(nums1[i], nums2[j]);
            }
            int mid = k / 2;
            int newI = min(i + mid, m) - 1;
            int newJ = min(j + mid, n) - 1;
            int pivot1 = nums1[newI], pivot2 = nums2[newJ];
            if (pivot1 <= pivot2) {
                k -= (newI - i + 1);
                i = newI + 1;
            } else {
                k -= (newJ - j + 1);
                j = newJ + 1;
            }
        }
        return 0;
    }
};