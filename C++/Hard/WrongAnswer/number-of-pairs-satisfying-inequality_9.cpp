class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        // Sort nums1 and nums2
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        // Find the number of pairs
        long long ans = 0;
        int n = nums1.size();
        for (int i = 0; i < n; i++) {
            int j = lower_bound(nums2.begin(), nums2.end(), nums1[i] - diff) - nums2.begin();
            ans += j;
        }
        
        return ans;
    }
};