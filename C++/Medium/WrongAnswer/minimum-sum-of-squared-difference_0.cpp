class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        
        long long res = 0;
        int n = nums1.size();
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        for (int i = 0; i < n; i++) {
            res += (long long)(nums1[i] - nums2[i]) * (nums1[i] - nums2[i]);
        }
        while (k1--) {
            int i = 0;
            while (i < n - 1 && nums1[i + 1] - nums1[i] <= nums1[i] - nums1[i - 1]) {
                i++;
            }
            res += (nums1[i] - nums1[i - 1]) * (nums1[i] - nums1[i - 1]) - (nums1[i + 1] - nums1[i]) * (nums1[i + 1] - nums1[i]);
            swap(nums1[i], nums1[i - 1]);
        }
        while (k2--) {
            int i = 0;
            while (i < n - 1 && nums2[i + 1] - nums2[i] <= nums2[i] - nums2[i - 1]) {
                i++;
            }
            res += (nums2[i] - nums2[i - 1]) * (nums2[i] - nums2[i - 1]) - (nums2[i + 1] - nums2[i]) * (nums2[i + 1] - nums2[i]);
            swap(nums2[i], nums2[i - 1]);
        }
        return res;
    }
};