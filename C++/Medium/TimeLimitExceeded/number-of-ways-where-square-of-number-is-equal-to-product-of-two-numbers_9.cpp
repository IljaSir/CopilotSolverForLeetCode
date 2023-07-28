class Solution {
public:
    int numTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        int res = 0;
        // type1
        for (int i = 0; i < nums1.size(); ++i) {
            long long num = (long long)nums1[i] * nums1[i];
            for (int j = 0; j < nums2.size(); ++j) {
                for (int k = j + 1; k < nums2.size(); ++k) {
                    if ((long long)nums2[j] * nums2[k] == num) {
                        res++;
                    }
                }
            }
        }
        // type2
        for (int i = 0; i < nums2.size(); ++i) {
            long long num = (long long)nums2[i] * nums2[i];
            for (int j = 0; j < nums1.size(); ++j) {
                for (int k = j + 1; k < nums1.size(); ++k) {
                    if ((long long)nums1[j] * nums1[k] == num) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
};