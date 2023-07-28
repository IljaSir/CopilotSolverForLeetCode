class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for(int i=0; i<n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        int ans = 0;
        if((start+sum[n])%2 != goal%2) return -1;
        if(start == goal) return 0;
        return dfs(nums, sum, start, goal, 0);
    }
    int dfs(vector<int>& nums, vector<int>& sum, int start, int goal, int idx) {
        int n = nums.size();
        if(start == goal) return 0;
        if(idx == n) return -1;
        int ans = -1;
        int a = dfs(nums, sum, start+nums[idx], goal, idx+1);
        if(a != -1) {
            ans = a+1;
        }
        int b = dfs(nums, sum, start-nums[idx], goal, idx+1);
        if(b != -1) {
            if(ans == -1) ans = b+1;
            else ans = min(ans, b+1);
        }
        int c = dfs(nums, sum, start^nums[idx], goal, idx+1);
        if(c != -1) {
            if(ans == -1) ans = c+1;
            else ans = min(ans, c+1);
        }
        return ans;
    }
};