class Solution {
public:
    int numTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        int ans = 0;
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                for(int k = j + 1; k < n2; k++) {
                    long long p = (long long)nums1[i] * nums1[i];
                    long long q = (long long)nums2[j] * nums2[k];
                    if(p == q) {
                        ans++;
                    }
                }
            }
        }
        for(int i = 0; i < n2; i++) {
            for(int j = 0; j < n1; j++) {
                for(int k = j + 1; k < n1; k++) {
                    long long p = (long long)nums2[i] * nums2[i];
                    long long q = (long long)nums1[j] * nums1[k];
                    if(p == q) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
};