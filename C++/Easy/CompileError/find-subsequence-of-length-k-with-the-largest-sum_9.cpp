class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> res;
        int left = n - k;
        for (int i = 0; i < n; i++) {
            while (!res.empty() && left > 0 && res.back() < nums[i]) {
                res.pop_back();
                left--;
            }
            res.push_back(nums[i]);
        }
        return vector<int>(res.begin(), res.begin() + k);
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        vector<int> res(k, 0);
        for (int i = max(0, k - n2); i <= k && i <= n1; i++) {
            vector<int> v1 = maxSubsequence(nums1, i);
            vector<int> v2 = maxSubsequence(nums2, k - i);
            vector<int> cur(k, 0);
            int p1 = 0, p2 = 0;
            for (int j = 0; j < k; j++) {
                cur[j] = greater(v1, p1, v2, p2) ? v1[p1++] : v2[p2++];
            }
            if (greater(cur, 0, res, 0)) {
                res.swap(cur);
            }
        }
        return res;
    }
};