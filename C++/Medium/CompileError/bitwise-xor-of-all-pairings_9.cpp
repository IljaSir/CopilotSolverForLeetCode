class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        int xorSum = 0;
        for (int i = 0; i < n1; ++i) {
            for (int j = 0; j < n2; ++j) {
                xorSum ^= nums1[i] ^ nums2[j];
            }
        }
        return xorSum;
    }
    int xorAllNumsOpt(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        int xorSum = 0;
        for (int i = 0; i < n1; ++i) {
            xorSum ^= nums1[i];
        }
        for (int j = 0; j < n2; ++j) {
            xorSum ^= nums2[j];
        }
        return xorSum;
    }
    int xorAllNumsOpt2(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        int xorSum = 0;
        for (int i = 0; i < n1; ++i) {
            xorSum ^= nums1[i];
        }
        for (int j = 0; j < n2; ++j) {
            xorSum ^= nums2[j];
        }
        return xorSum;
    }
    int xorAllNumsOpt3(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        int xorSum = 0;
        for (int i = 0; i < n1; ++i) {
            xorSum ^= nums1[i];
        }
        for (int j = 0; j < n2; ++j) {
            xorSum ^= nums2[j];
        }
        return xorSum;
    }
    int xorAllNumsOpt4(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        int xorSum = 0;
        for (int i = 0; i < n1; ++i) {
            xorSum ^= nums1[i];
        }
        for (int j = 0;
    }
};