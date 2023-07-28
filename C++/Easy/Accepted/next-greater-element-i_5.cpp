class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> res;
        for (int i = 0; i < nums1.size(); i++) {
            int j = 0;
            while (nums2[j] != nums1[i]) j++;
            while (j < nums2.size() && nums2[j] <= nums1[i]) j++;
            res.push_back(j < nums2.size() ? nums2[j] : -1);
        }
        return res;
    }
};