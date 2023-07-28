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
    int xorOperation(int n, int start) {
        int nums1[n];
        int nums2[n];
        for (int i = 0; i < n; ++i) {
            nums1[i] = start + 2 * i;
            nums2[i] = start + 2 * i + 1;
        }
        int res = xorAllNums(nums1, nums2);
        return res;
    }
};