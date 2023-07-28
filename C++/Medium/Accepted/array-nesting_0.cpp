class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        
        int n = nums.size();
        vector<bool> vis(n, false);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                int cnt = 0;
                for (int j = i; !vis[j]; j = nums[j]) {
                    vis[j] = true;
                    ++cnt;
                }
                ans = max(ans, cnt);
            }
        }
        return ans;
    }
};