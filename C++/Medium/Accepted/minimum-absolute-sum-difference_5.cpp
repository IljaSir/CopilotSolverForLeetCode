class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        long long sum = 0;
        long long mod = 1e9 + 7;
        vector<int> nums1_copy = nums1;
        sort(nums1_copy.begin(), nums1_copy.end());
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            int diff = abs(nums1[i] - nums2[i]);
            sum += diff;
            int pos = lower_bound(nums1_copy.begin(), nums1_copy.end(), nums2[i]) - nums1_copy.begin();
            if (pos < n) {
                res = max(res, (long long)diff - (nums1_copy[pos] - nums2[i]));
            }
            if (pos > 0) {
                res = max(res, (long long)diff - (nums2[i] - nums1_copy[pos - 1]));
            }
        }
        return (sum - res) % mod;
    }
};