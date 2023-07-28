class Solution {
public:
    int numTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        int res = 0;
        unordered_map<long long, int> m1, m2;
        for (int i = 0; i < nums1.size(); i++) {
            for (int j = i + 1; j < nums1.size(); j++) {
                m1[1LL * nums1[i] * nums1[j]]++;
            }
        }
        for (int i = 0; i < nums2.size(); i++) {
            for (int j = i + 1; j < nums2.size(); j++) {
                m2[1LL * nums2[i] * nums2[j]]++;
            }
        }
        for (int i = 0; i < nums1.size(); i++) {
            if (m2.count(1LL * nums1[i] * nums1[i])) {
                res += m2[1LL * nums1[i] * nums1[i]];
            }
        }
        for (int i = 0; i < nums2.size(); i++) {
            if (m1.count(1LL * nums2[i] * nums2[i])) {
                res += m1[1LL * nums2[i] * nums2[i]];
            }
        }
        return res;
    }
};