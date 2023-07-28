class Solution {
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        
        int i = 0, j = 0;
        int m = nums1.size();
        int n = nums2.size();
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
    int minimumCommonValue(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        if (m < n) {
            return getCommon(nums1, nums2);
        } else {
            return getCommon(nums2, nums1);
        }
    }
};