class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        
        int ret = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            for (int j = 0; j < nums2.size(); ++j) {
                ret ^= nums1[i] ^ nums2[j];
            }
        }
        return ret;
    }
    int xorAllNums2(vector<int>& nums1, vector<int>& nums2) {
        int ret = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            int cnt1 = (nums1[i] + 1) / 2;
            int cnt2 = (nums1[i] + 1) / 2;
            ret ^= cnt1 % 2 * (nums1[i] % 2);
            ret ^= cnt2 % 2 * (nums1[i] % 2);
        }
        for (int i = 0; i < nums2.size(); ++i) {
            int cnt1 = (nums2[i] + 1) / 2;
            int cnt2 = (nums2[i] + 1) / 2;
            ret ^= cnt1 % 2 * (nums2[i] % 2);
            ret ^= cnt2 % 2 * (nums2[i] % 2);
        }
        return ret;
    }
    int xorAllNums3(vector<int>& nums1, vector<int>& nums2) {
        int ret = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            int cnt1 = (nums1[i] + 1) / 2;
            int cnt2 = (nums1[i]) / 2;
            ret ^= cnt1 % 2 * (nums1[i] % 2);
            ret ^= cnt2 % 2 * (nums1[i] % 2);
        }
        for (int i = 0; i < nums2.size(); ++i) {
            int cnt1 = (nums2[i] + 1) / 2;
            int cnt2 = (nums2[i]) / 2;
            ret ^= cnt1 % 2 * (nums2[i] % 2);
            ret ^= cnt2 % 2 * (nums2[i] % 2);
        }
        return ret;
    }
};