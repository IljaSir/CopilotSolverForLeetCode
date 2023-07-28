class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        
        int ans = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            for (int j = 0; j < nums2.size(); ++j) {
                ans ^= (nums1[i] ^ nums2[j]);
            }
        }
        return ans;
    }
    int xorAllNums2(vector<int>& nums1, vector<int>& nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            ans ^= nums1[i];
        }
        for (int i = 0; i < nums2.size(); ++i) {
            ans ^= nums2[i];
        }
        return ans;
    }
    int xorAllNums3(vector<int>& nums1, vector<int>& nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            ans ^= (nums1[i] * nums2.size());
        }
        for (int i = 0; i < nums2.size(); ++i) {
            ans ^= (nums2[i] * nums1.size());
        }
        return ans;
    }
    int xorAllNums4(vector<int>& nums1, vector<int>& nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            ans ^= (nums1[i] & 1);
        }
        for (int i = 0; i < nums2.size(); ++i) {
            ans ^= (nums2[i] & 1);
        }
        return ans;
    }
    int xorAllNums5(vector<int>& nums1, vector<int>& nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            ans ^= (nums1[i] & 1);
        }
        for (int i = 0; i < nums2.size(); ++i) {
            ans ^= (nums2[i] & 1);
        }
        return ans;
    }
};