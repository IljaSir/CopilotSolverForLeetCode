class Solution {
public:
    int numTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size(), n2 = nums2.size();
        int ans = 0;
        unordered_map<long long, int> mp1, mp2;
        for (int i = 0; i < n1; i++) {
            for (int j = i + 1; j < n1; j++) {
                mp1[1LL * nums1[i] * nums1[j]]++;
            }
        }
        for (int i = 0; i < n2; i++) {
            for (int j = i + 1; j < n2; j++) {
                mp2[1LL * nums2[i] * nums2[j]]++;
            }
        }
        for (int i = 0; i < n1; i++) {
            long long x = 1LL * nums1[i] * nums1[i];
            if (mp2.count(x)) {
                ans += mp2[x];
            }
        }
        for (int i = 0; i < n2; i++) {
            long long x = 1LL * nums2[i] * nums2[i];
            if (mp1.count(x)) {
                ans += mp1[x];
            }
        }
        return ans;
    }
};