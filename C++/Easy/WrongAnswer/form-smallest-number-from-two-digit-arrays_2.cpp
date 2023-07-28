class Solution {
public:
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        
        int ans = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            ans = ans * 10 + nums1[i];
        }
        for (int i = 0; i < nums2.size(); ++i) {
            ans = ans * 10 + nums2[i];
        }
        return ans;
    }
};