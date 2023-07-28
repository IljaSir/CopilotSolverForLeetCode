class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        long long ans = 0;
        for (int i = 0; i < nums1.size(); ++i) {
            for (int j = 0; j < nums2.size(); ++j) {
                if (i < j && nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff) {
                    ans++;
                }
            }
        }
        return ans;
    }
};