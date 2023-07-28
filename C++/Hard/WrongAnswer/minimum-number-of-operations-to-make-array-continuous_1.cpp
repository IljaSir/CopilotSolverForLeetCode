class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = n;
        for (int i = 0, j = 0; j < n; ++j) {
            while (nums[j] - nums[i] >= n) ++i;
            ans = min(ans, n - (j - i + 1));
        }
        return ans;
    }
};