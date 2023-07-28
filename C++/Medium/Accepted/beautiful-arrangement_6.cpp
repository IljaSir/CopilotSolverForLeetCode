class Solution {
public:
    int countArrangement(int n) {
        
        int ans = 0;
        vector<int> nums(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            nums[i] = i;
        }
        dfs(nums, 1, ans);
        return ans;
    }
    void dfs(vector<int>& nums, int idx, int& ans) {
        if (idx == nums.size()) {
            ++ans;
            return;
        }
        for (int i = idx; i < nums.size(); ++i) {
            swap(nums[idx], nums[i]);
            if (nums[idx] % idx == 0 || idx % nums[idx] == 0) {
                dfs(nums, idx + 1, ans);
            }
            swap(nums[idx], nums[i]);
        }
    }
};