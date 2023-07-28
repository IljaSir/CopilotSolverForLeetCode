class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> nums3 = nums1;
        sort(nums3.begin(), nums3.end());
        int maxDiff = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int diff = abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % 1000000007;
            int index = lower_bound(nums3.begin(), nums3.end(), nums2[i]) - nums3.begin();
            if (index < n) {
                maxDiff = max(maxDiff, diff - (nums3[index] - nums2[i]));
            }
            if (index > 0) {
                maxDiff = max(maxDiff, diff - (nums2[i] - nums3[index - 1]));
            }
        }
        return (sum - maxDiff + 1000000007) % 1000000007;
    }
};