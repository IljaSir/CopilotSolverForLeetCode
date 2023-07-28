class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        long long ans = 0;
        int n = nums1.size();
        vector<int> cnt(20005, 0);
        for (int i = 0; i < n; ++i) {
            int cur = nums1[i] - nums2[i] + diff;
            if (cur > 0) {
                ans += cnt[cur];
            }
            int cur2 = nums1[i] - nums2[i] - diff;
            if (cur2 > 0) {
                ++cnt[cur2];
            }
        }
        return ans;
    }
};