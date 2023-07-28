class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        int n = n1 + n2;
        vector<int> nums(n);
        int i1 = 0, i2 = 0;
        for (int i = 0; i < n; ++i) {
            if (i1 < n1 && i2 < n2) {
                if (nums1[i1] < nums2[i2]) {
                    nums[i] = nums1[i1];
                    ++i1;
                } else {
                    nums[i] = nums2[i2];
                    ++i2;
                }
            } else if (i1 < n1) {
                nums[i] = nums1[i1];
                ++i1;
            } else {
                nums[i] = nums2[i2];
                ++i2;
            }
        }
        if (n % 2 == 0) {
            return (nums[n/2-1] + nums[n/2]) / 2.0;
        } else {
            return nums[n/2];
        }
    }
};