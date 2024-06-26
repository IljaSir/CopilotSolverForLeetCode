class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        
        int sum1 = accumulate(nums1.begin(), nums1.end(), 0);
        int sum2 = accumulate(nums2.begin(), nums2.end(), 0);
        if (sum1 == sum2) return 0;
        if (sum1 > sum2) return minOperations(nums2, nums1);
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end(), greater<int>());
        int i = 0, j = 0, res = 0;
        while (sum1 < sum2) {
            int v1 = i < nums1.size() ? 6 - nums1[i] : 0;
            int v2 = j < nums2.size() ? nums2[j] - 1 : 0;
            if (v1 > v2) {
                sum1 += v1;
                ++i;
            } else {
                sum2 -= v2;
                ++j;
            }
            ++res;
        }
        return res;
    }
};