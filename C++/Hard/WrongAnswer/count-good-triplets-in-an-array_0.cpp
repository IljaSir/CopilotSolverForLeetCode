class Solution {
public:
    long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        long long ans = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            for (int j = i + 1; j < nums1.size(); ++j) {
                if (nums1[i] > nums1[j]) continue;
                for (int k = j + 1; k < nums1.size(); ++k) {
                    if (nums1[j] > nums1[k]) continue;
                    if (nums2[i] < nums2[j] && nums2[j] < nums2[k]) ++ans;
                }
            }
        }
        return ans;
    }
};