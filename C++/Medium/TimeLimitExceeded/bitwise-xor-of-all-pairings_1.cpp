class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        
        int res = 0;
        for (int i = 0; i < nums1.size(); i++) {
            for (int j = 0; j < nums2.size(); j++) {
                res ^= (nums1[i] ^ nums2[j]);
            }
        }
        return res;
    }
    int xorAllNums(vector<int>& nums1, vector<int>& nums2, int k) {
        int res = 0;
        for (int i = 0; i < nums1.size(); i++) {
            for (int j = 0; j < nums2.size(); j++) {
                res ^= (nums1[i] ^ nums2[j]);
                if (res == k) return res;
            }
        }
        return res;
    }
    int getXORSum(vector<int>& nums1, vector<int>& nums2) {
        int res = 0;
        int n1 = nums1.size(), n2 = nums2.size();
        int k = xorAllNums(nums1, nums2);
        for (int i = 0; i < n1; i++) {
            res ^= (xorAllNums(nums1, nums2, k ^ nums1[i]));
        }
        return res;
    }
};