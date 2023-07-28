class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        
        int res = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            for (int j = 0; j < nums2.size(); ++j) {
                res ^= nums1[i] ^ nums2[j];
            }
        }
        return res;
    }
    int xorAllPairs(vector<int>& nums1, vector<int>& nums2) {
        int res = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.size(); ++j) {
            res ^= nums2[j];
        }
        return res;
    }
    int xorAll(vector<int>& nums1, vector<int>& nums2) {
        int res = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.size(); ++j) {
            res ^= nums2[j];
        }
        return res;
    }
};