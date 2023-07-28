class Solution {
public:
    int countArrangement(int n) {
        
        vector<int> nums(n);
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int ans = 0;
        dfs(nums, 0, ans);
        return ans;
    }
    
    void dfs(vector<int>& nums, int start, int& ans) {
        if (start == nums.size()) {
            ans++;
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            swap(nums[start], nums[i]);
            if (nums[start] % (start + 1) == 0 || (start + 1) % nums[start] == 0) {
                dfs(nums, start + 1, ans);
            }
            swap(nums[start], nums[i]);
        }
    }
};