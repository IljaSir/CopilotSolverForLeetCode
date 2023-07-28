class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> res(k);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && res[j - 1] < nums[i]) --j;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size(), m = nums2.size();
        vector<int> res(k);
        for (int i = max(0, k - m); i <= k && i <= n; ++i) {
            auto v1 = maxSubsequence(nums1, i);
            auto v2 = maxSubsequence(nums2, k - i);
            vector<int> cur(k);
            int p1 = 0, p2 = 0;
            for (int j = 0; j < k; ++j) {
                cur[j] = greater(v1, p1, v2, p2) ? v1[p1++] : v2[p2++];
            }
            if (greater(cur, 0, res, 0)) res = cur;
        }
        return res;
    }
};