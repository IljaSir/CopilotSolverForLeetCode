class Solution {
public:
    int maximumsSplicedArray(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> dp1(n + 1), dp2(n + 1);
        dp1[0] = nums1[0];
        dp2[0] = nums2[0];
        for (int i = 1; i < n; ++i) {
            dp1[i] = dp1[i - 1] + nums1[i];
            dp2[i] = dp2[i - 1] + nums2[i];
        }
        int ans = max(dp1[n - 1], dp2[n - 1]);
        int l = 0, r = n - 1;
        while (l < n && r >= 0) {
            if (nums1[l] > nums2[r]) {
                ans = max(ans, dp1[l] + dp2[n - 1] - dp2[r]);
                ++l;
            } else {
                ans = max(ans, dp2[r] + dp1[n - 1] - dp1[l]);
                --r;
            }
        }
        return ans;
    }
};