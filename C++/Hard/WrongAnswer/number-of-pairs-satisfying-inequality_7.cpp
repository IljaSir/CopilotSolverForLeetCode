class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        long long n = nums1.size();
        long long ans = 0;
        for(int i = 0; i < n; i++) {
            int x = nums1[i] - nums2[i] + diff;
            int y = nums1[i] - nums2[i] - diff;
            ans += upper_bound(nums1.begin(), nums1.end(), x) - lower_bound(nums1.begin(), nums1.end(), y);
            if (nums1[i] >= y && nums1[i] <= x) ans--;
        }
        return ans;
    }
};