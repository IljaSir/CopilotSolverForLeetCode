class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> res(k, 0);
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && res[j - 1] < nums[i]) --j;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size(), m = nums2.size();
        vector<int> res(k, 0);
        for (int i = max(0, k - m); i <= min(k, n); ++i) {
            vector<int> res1 = maxSubsequence(nums1, i);
            vector<int> res2 = maxSubsequence(nums2, k - i);
            vector<int> tmp(k, 0);
            int p1 = 0, p2 = 0, p = 0;
            while (p1 < res1.size() || p2 < res2.size()) {
                tmp[p++] = res1 > res2 ? res1[p1++] : res2[p2++];
            }
            res = max(res, tmp);
        }
        return res;
    }
};