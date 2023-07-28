class Solution {
public:
    int minDays(int n) {
        
        vector<int> dp(n+1, -1);
        return dfs(n, dp);
    }
};