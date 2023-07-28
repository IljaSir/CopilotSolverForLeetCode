class Solution {
public:
    int countArrangement(int n) {
        
        vector<int> nums(n);
        for (int i = 0; i < n; ++i) {
            nums[i] = i + 1;
        }
        int ans = 0;
        dfs(nums, 0, ans);
        return ans;
    }
};