class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        long long ans = 0;
        int n = nums1.size();
        vector<int> cnt(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            if (nums1[i] == nums2[i]) {
                ++cnt[nums1[i]];
            } else if (nums1[i] > nums2[i]) {
                ++cnt[nums1[i]];
                --cnt[nums2[i]];
            } else {
                ++cnt[nums2[i]];
                --cnt[nums1[i]];
            }
        }
        int cur = 0;
        for (int i = 1; i <= n; ++i) {
            cur += cnt[i];
            ans += min(cur, i);
        }
        return ans;
    }
};