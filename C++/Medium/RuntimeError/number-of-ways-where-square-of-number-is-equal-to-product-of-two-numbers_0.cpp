class Solution {
public:
    int numTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        int ans = 0;
        for (int i = 0; i < nums1.size(); i++) {
            for (int j = 0; j < nums2.size(); j++) {
                for (int k = j+1; k < nums2.size(); k++) {
                    if (nums1[i] == sqrt(nums2[j]*nums2[k])) {
                        ans++;
                    }
                }
            }
        }
        for (int i = 0; i < nums2.size(); i++) {
            for (int j = 0; j < nums1.size(); j++) {
                for (int k = j+1; k < nums1.size(); k++) {
                    if (nums2[i] == sqrt(nums1[j]*nums1[k])) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
};