class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        vector<int> res;
        int n = nums.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        left[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (i < k) {
                left[i] = max(left[i - 1], nums[i]);
            } else {
                left[i] = max(left[i - 1], nums[i - k]);
            }
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            if (i >= n - k) {
                right[i] = min(right[i + 1], nums[i]);
            } else {
                right[i] = min(right[i + 1], nums[i + k]);
            }
        }
        for (int i = k; i < n - k; ++i) {
            if (left[i] <= nums[i] && nums[i] <= right[i]) {
                res.push_back(i);
            }
        }
        return res;
    }
};