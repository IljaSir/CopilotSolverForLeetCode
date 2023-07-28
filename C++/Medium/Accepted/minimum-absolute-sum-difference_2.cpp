class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> sortedNums1(nums1);
        sort(sortedNums1.begin(), sortedNums1.end());
        long sum = 0;
        long maxDiff = 0;
        for (int i = 0; i < n; i++) {
            long diff = abs(nums1[i] - nums2[i]);
            sum += diff;
            int j = lower_bound(sortedNums1.begin(), sortedNums1.end(), nums2[i]) - sortedNums1.begin();
            if (j < n) {
                maxDiff = max(maxDiff, diff - (sortedNums1[j] - nums2[i]));
            }
            if (j > 0) {
                maxDiff = max(maxDiff, diff - (nums2[i] - sortedNums1[j - 1]));
            }
        }
        return (sum - maxDiff) % 1000000007;
    }
};