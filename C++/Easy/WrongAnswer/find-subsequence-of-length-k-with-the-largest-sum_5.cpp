class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> res(k);
        int top = -1;
        for (int i = 0; i < n; ++i) {
            while (top >= 0 && top + n - i >= k && nums[i] > res[top]) {
                --top;
            }
            if (top + 1 < k) {
                res[++top] = nums[i];
            }
        }
        return res;
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size();
        int m = nums2.size();
        vector<int> res(k);
        for (int i = max(0, k - m); i <= k && i <= n; ++i) {
            auto candidate = merge(maxSubsequence(nums1, i), maxSubsequence(nums2, k - i), k);
            if (compare(candidate, 0, res, 0) > 0) {
                res = candidate;
            }
        }
        return res;
    }
    vector<int> merge(const vector<int>& nums1, const vector<int>& nums2, int k) {
        vector<int> res(k);
        int index1 = 0, index2 = 0;
        for (int i = 0; i < k; ++i) {
            if (compare(nums1, index1, nums2, index2) > 0) {
                res[i] = nums1[index1++];
            }
            else {
                res[i] = nums2[index2++];
            }
        }
        return res;
    }
    int compare(const vector<int>& nums1, int index1, const vector<int>& nums2, int index2) {
        int x = nums1.size(), y = nums2.size();
        while (index1 < x && index2 < y) {
            int difference = nums1[index1] - nums2[index2];
            if (difference != 0) {
                return difference;
            }
            ++index1;
            ++index2;
        }
        return (x - index1) - (y - index2);
    }
};