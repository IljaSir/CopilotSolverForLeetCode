class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> ans;
        vector<int> left(n), right(n);
        left[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            left[i] = max(left[i - 1], nums[i]);
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = min(right[i + 1], nums[i]);
        }
        for (int i = k; i <= n - k - 1; ++i) {
            if (left[i - 1] <= nums[i] && nums[i] <= right[i + 1]) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};