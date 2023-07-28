class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        long long ans = 0;
        vector<int> cnt(2*n+1, 0);
        for (int i = 0; i < n; ++i) {
            if (nums1[i] == nums2[i]) {
                ++cnt[nums1[i]];
            } else {
                ++cnt[nums1[i]];
                ++cnt[nums2[i]];
                ans += i;
            }
        }
        int m = 0;
        for (int i = 1; i <= 2*n; ++i) {
            if (cnt[i] == n) {
                ++m;
            }
        }
        if (m == 2) {
            return -1;
        }
        if (m == 1) {
            return ans + n - 1;
        }
        return ans;
    }
};