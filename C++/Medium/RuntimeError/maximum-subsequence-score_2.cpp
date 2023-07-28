class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        long long res = 0;
        int n = nums1.size();
        for (int i = 0; i <= k; ++i) {
            if (i <= n && k - i <= n) {
                res = max(res, maxScore(nums1, nums2, i));
            }
        }
        return res;
    }
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k, int i1, int i2) {
        long long res = 0;
        int n = nums1.size();
        for (int i = 0; i <= k; ++i) {
            if (i <= n && k - i <= n) {
                res = max(res, maxScore(nums1, nums2, i, i1, i2));
            }
        }
        return res;
    }
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k, int i1, int i2, int j1, int j2) {
        long long res = 0;
        int n = nums1.size();
        for (int i = 0; i <= k; ++i) {
            if (i <= n && k - i <= n) {
                res = max(res, maxScore(nums1, nums2, i, i1, i2, j1, j2));
            }
        }
        return res;
    }
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k, int i1, int i2, int j1, int j2, int l1, int l2) {
        long long res = 0;
        int n = nums1.size();
        for (int i = 0; i <= k; ++i) {
            if (i <= n && k - i <= n) {
                res = max(res, maxScore(nums1, nums2, i, i1, i2, j1, j2, l1, l2));
            }
        }
        return res;
    }
};