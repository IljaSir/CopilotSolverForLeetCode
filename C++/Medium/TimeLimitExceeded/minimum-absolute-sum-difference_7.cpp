class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int diff = 0;
        int maxDiff = 0;
        int maxDiffIndex = 0;
        int minAbsDiff = 0;
        int minAbsDiffIndex = 0;
        for (int i = 0; i < n; i++) {
            diff = abs(nums1[i] - nums2[i]);
            minAbsDiff = diff;
            minAbsDiffIndex = i;
            for (int j = 0; j < n; j++) {
                if (abs(nums1[j] - nums2[i]) < minAbsDiff) {
                    minAbsDiff = abs(nums1[j] - nums2[i]);
                    minAbsDiffIndex = j;
                }
            }
            if (diff - minAbsDiff > maxDiff) {
                maxDiff = diff - minAbsDiff;
                maxDiffIndex = i;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += abs(nums1[i] - nums2[i]);
        }
        return sum - maxDiff;
    }
};