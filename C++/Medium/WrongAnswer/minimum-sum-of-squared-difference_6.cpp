class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int n = nums1.size();
        int i = 0, j = 0;
        int k = k1 + k2;
        while (k--) {
            if (i < n && j < n) {
                if (abs(nums1[i] - nums2[j]) < abs(nums1[i + 1] - nums2[j + 1])) {
                    ++i;
                } else {
                    ++j;
                }
            } else if (i < n) {
                ++i;
            } else {
                ++j;
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += (long long)(nums1[i] - nums2[i]) * (nums1[i] - nums2[i]);
        }
        return ans;
    }
};