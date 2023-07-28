class Solution {
public:
    int numSquarefulPerms(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        vector<bool> used(n, false);
        sort(nums.begin(), nums.end());
        function<bool(int, int)> isSquare = [&](int a, int b) {
            int c = sqrt(a+b);
            return c*c == a+b;
        };
        function<void(int)> dfs = [&](int cur) {
            if (cur == n) {
                ans++;
                return;
            }
            for (int i = 0; i < n; ++i) {
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                if (cur > 0 && !isSquare(nums[i], nums[cur-1])) continue;
                used[i] = true;
                dfs(cur+1);
                used[i] = false;
            }
        };
        dfs(0);
        return ans;
    }
};