class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> result;
        vector<int> maxLeft(n);
        vector<int> minRight(n);
        int mx = nums[0];
        for (int i = 0; i < n; i++) {
            mx = max(mx, nums[i]);
            maxLeft[i] = mx;
        }
        int mn = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            mn = min(mn, nums[i]);
            minRight[i] = mn;
        }
        for (int i = k; i <= n - k - 1; i++) {
            if (maxLeft[i - 1] <= nums[i] && nums[i] <= minRight[i + 1]) {
                result.push_back(i);
            }
        }
        return result;
    }
};