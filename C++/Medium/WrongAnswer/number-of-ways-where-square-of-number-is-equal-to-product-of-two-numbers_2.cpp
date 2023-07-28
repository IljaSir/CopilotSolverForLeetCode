class Solution {
public:
    int numTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        int res = 0;
        for (int i = 0; i < nums1.size(); i++) {
            for (int j = 0; j < nums1.size(); j++) {
                for (int k = 0; k < nums2.size(); k++) {
                    if (nums1[i] * nums1[j] == nums2[k] * nums2[k] && i != j) {
                        res++;
                    }
                }
            }
        }
        for (int i = 0; i < nums2.size(); i++) {
            for (int j = 0; j < nums2.size(); j++) {
                for (int k = 0; k < nums1.size(); k++) {
                    if (nums2[i] * nums2[j] == nums1[k] * nums1[k] && i != j) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
};