class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        long long ans = 0;
        int n = nums1.size();
        vector<int> cnt(20001, 0);
        for (int i = 0; i < n; i++) {
            int l = nums1[i] - nums2[i] + diff;
            int r = nums1[i] - nums2[i] + 10000;
            if (l > 0) {
                ans += cnt[l];
            }
            cnt[nums1[i] - nums2[i] + 10000]++;
        }
        return ans;
    }
};