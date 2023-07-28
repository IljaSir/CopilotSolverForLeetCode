class Solution {
public:
    int numSquarefulPerms(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> out;
        vector<bool> used(n, false);
        sort(nums.begin(), nums.end());
        int ans = 0;
        dfs(nums, used, out, ans);
        return ans;
    }
    void dfs(vector<int>& nums, vector<bool>& used, vector<int>& out, int& ans) {
        if (out.size() == nums.size()) {
            ans++;
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (out.size() > 0 && !isSquare(out.back() + nums[i])) continue;
            out.push_back(nums[i]);
            used[i] = true;
            dfs(nums, used, out, ans);
            out.pop_back();
            used[i] = false;
        }
    }
    bool isSquare(int n) {
        int sq = sqrt(n);
        return sq * sq == n;
    }
};