class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        vector<int> ans;
        int n = nums.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i < k) {
                left[i] = min(left[i - 1], nums[i]);
            }
            if (i >= n - k) {
                right[i] = max(right[i + 1], nums[i]);
            }
        }
        for (int i = k; i < n - k; i++) {
            if (left[i - 1] <= nums[i] && nums[i] <= right[i + 1]) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};