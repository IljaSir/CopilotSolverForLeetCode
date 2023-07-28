class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int mod = 1e9 + 7;
        vector<int> nums3(nums1);
        sort(nums3.begin(), nums3.end());
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; ++i) {
            int diff = abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % mod;
            int j = lower_bound(nums3.begin(), nums3.end(), nums2[i]) - nums3.begin();
            if (j < n) {
                maxn = max(maxn, diff - (nums3[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = max(maxn, diff - (nums2[i] - nums3[j - 1]));
            }
        }
        return (sum - maxn + mod) % mod;
    }
};