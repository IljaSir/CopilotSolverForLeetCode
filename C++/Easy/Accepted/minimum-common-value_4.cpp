class Solution {
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        
        int i = 0, j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] == nums2[j]) return nums1[i];
            if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        return -1;
    }
    int getCommon(vector<int>& nums1, vector<int>& nums2, int i, int j) {
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] == nums2[j]) return nums1[i];
            if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        return -1;
    }
    int getCommon(vector<int>& nums1, vector<int>& nums2, int i, int j, int k) {
        while (i < nums1.size() && j < nums2.size() && k < nums2.size()) {
            if (nums1[i] == nums2[j] && nums2[j] == nums2[k]) return nums1[i];
            if (nums1[i] < nums2[j]) i++;
            else if (nums2[j] < nums2[k]) j++;
            else k++;
        }
        return -1;
    }
    int getCommon(vector<int>& nums1, vector<int>& nums2, int i, int j, int k, int l) {
        while (i < nums1.size() && j < nums2.size() && k < nums2.size() && l < nums2.size()) {
            if (nums1[i] == nums2[j] && nums2[j] == nums2[k] && nums2[k] == nums2[l]) return nums1[i];
            if (nums1[i] < nums2[j]) i++;
            else if (nums2[j] < nums2[k]) j++;
            else if (nums2[k] < nums2[l]) k++;
            else l++;
        }
        return -1;
    }
};