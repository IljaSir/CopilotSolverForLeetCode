class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> res(k);
        int top = -1;
        for (int i = 0; i < n; ++i) {
            while (top >= 0 && n - i + top >= k && res[top] < nums[i]) {
                --top;
            }
            if (top < k - 1) {
                res[++top] = nums[i];
            }
        }
        return res;
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size(), m = nums2.size();
        vector<int> res(k);
        for (int i = max(0, k - m); i <= min(k, n); ++i) {
            auto v1 = maxSubsequence(nums1, i);
            auto v2 = maxSubsequence(nums2, k - i);
            vector<int> cur(k);
            auto p1 = v1.begin(), p2 = v2.begin();
            auto p = cur.begin();
            while (p1 != v1.end() || p2 != v2.end()) {
                *p++ = lexicographical_compare(p1, v1.end(), p2, v2.end()) ? *p2++ : *p1++;
            }
            res = max(res, cur);
        }
        return res;
    }
};