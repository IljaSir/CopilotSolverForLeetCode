class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        long long res = 0;
        for (int i = 0; i < nums1.size(); i++) {
            for (int j = i + 1; j < nums1.size(); j++) {
                if (nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff) {
                    res++;
                }
            }
        }
        return res;
    }
};