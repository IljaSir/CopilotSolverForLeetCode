class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> mins(n);
        mins[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            mins[i] = min(mins[i + 1], nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int j = upper_bound(mins.begin() + i, mins.end(), nums[i]) - mins.begin();
            ans = max(ans, j - i);
        }
        return ans;
    }
};