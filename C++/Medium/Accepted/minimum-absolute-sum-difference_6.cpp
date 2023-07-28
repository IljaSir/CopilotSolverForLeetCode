class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int mod = 1e9 + 7;
        long long sum = 0;
        vector<int> sorted(nums1);
        sort(sorted.begin(), sorted.end());
        int maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = abs(nums1[i] - nums2[i]);
            sum += diff;
            int j = lower_bound(sorted.begin(), sorted.end(), nums2[i]) - sorted.begin();
            if (j < n) {
                maxn = max(maxn, diff - (sorted[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = max(maxn, diff - (nums2[i] - sorted[j - 1]));
            }
        }
        return (sum - maxn) % mod;
    }
};