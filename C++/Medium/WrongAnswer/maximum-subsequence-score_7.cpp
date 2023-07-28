class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<long long> pre1(k + 1, 0), pre2(k + 1, 0);
        for (int i = 1; i <= k; i++) {
            pre1[i] = pre1[i - 1] + nums1[i - 1];
            pre2[i] = pre2[i - 1] + nums2[i - 1];
        }
        vector<long long> suf1(k + 1, 0), suf2(k + 1, 0);
        for (int i = k - 1; i >= 0; i--) {
            suf1[i] = suf1[i + 1] + nums1[nums1.size() - k + i];
            suf2[i] = suf2[i + 1] + nums2[nums2.size() - k + i];
        }
        long long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = max(ans, pre1[i] * min(nums2[i], nums1[i]) + suf2[i] * min(nums1[i], nums2[i]));
            ans = max(ans, pre2[i] * min(nums1[i], nums2[i]) + suf1[i] * min(nums2[i], nums1[i]));
        }
        return ans;
    }
};