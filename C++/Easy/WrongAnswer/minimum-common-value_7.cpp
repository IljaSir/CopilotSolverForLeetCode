class Solution {
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        
        int i = 0;
        int j = 0;
        int result = -1;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] == nums2[j]) {
                result = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
};