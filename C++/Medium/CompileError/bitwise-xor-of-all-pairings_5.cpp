class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        
        int res = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            res ^= nums1[i];
        }
        for (int i = 0; i < nums2.size(); ++i) {
            res ^= nums2[i];
        }
        return res;
    }
    int xorAllPairs(vector<int>& nums1, vector<int>& nums2) {
        int res = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            for (int j = 0; j < nums2.size(); ++j) {
                res ^= nums1[i] ^ nums2[j];
            }
        }
        return res;
    }
    int xorAllPairs2(vector<int>& nums1, vector<int>& nums2) {
        int res = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.size(); ++j) {
            res ^= nums2[j];
        }
        return res;
    }
    int xorAllPairs3(vector<int>& nums1, vector<int>& nums2) {
        int res = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.size(); ++j) {
            res ^= nums2[j];
        }
        return res;
    }
    int xorAllPairs4(vector<int>& nums1, vector<int>& nums2) {
        int res = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.size(); ++j) {
            res ^= nums2[j];
        }
        return res;
    }
    int xorAllPairs5(vector<int>& nums1, vector<int>& nums2) {
        int res = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.size(); ++j) {
            res ^= nums2[j];
    }
};