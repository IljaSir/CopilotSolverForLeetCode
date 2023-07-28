class Solution {
public:
    int maximumsSplicedArray(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> preSum1(n + 1), preSum2(n + 1);
        for (int i = 0; i < n; i++) {
            preSum1[i + 1] = preSum1[i] + nums1[i];
            preSum2[i + 1] = preSum2[i] + nums2[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = n;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (preSum1[m + 1] - preSum1[i] == preSum2[m + 1] - preSum2[i]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            res = max(res, preSum1[l] - preSum1[i] + preSum2[l]);
            res = max(res, preSum1[i] + preSum2[i]);
        }
        return res;
    }
};