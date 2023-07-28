class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> res;
        for (int i = 0; i < n; ++i) {
            while (!res.empty() && n - i + res.size() > k && res.back() < nums[i]) {
                res.pop_back();
            }
            if (res.size() < k) {
                res.push_back(nums[i]);
            }
        }
        return res;
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int m = nums1.size(), n = nums2.size();
        vector<int> res(k, 0);
        for (int i = max(0, k - n); i <= min(k, m); ++i) {
            vector<int> res1 = maxSubsequence(nums1, i);
            vector<int> res2 = maxSubsequence(nums2, k - i);
            vector<int> cur(k, 0);
            int p1 = 0, p2 = 0, p = 0;
            while (p1 < res1.size() || p2 < res2.size()) {
                cur[p++] = greater(res1, p1, res2, p2) ? res1[p1++] : res2[p2++];
            }
            if (greater(cur, 0, res, 0)) {
                res.swap(cur);
            }
        }
        return res;
    }
    bool greater(vector<int>& nums1, int i, vector<int>& nums2, int j) {
        while (i < nums1.size() && j < nums2.size() && nums1[i] == nums2[j]) {
            ++i;
            ++j;
        }
        return j == nums2.size() || (i < nums1.size() && nums1[i] > nums2[j]);
    }
};