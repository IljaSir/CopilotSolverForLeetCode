class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        vector<int> result;
        int n = nums.size();
        vector<int> left(n), right(n);
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = max(left[i-1], nums[i]);
        }
        right[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = min(right[i+1], nums[i]);
        }
        for (int i = k; i < n-k; i++) {
            if (left[i] <= nums[i] && nums[i] <= right[i]) {
                result.push_back(i);
            }
        }
        return result;
    }
};