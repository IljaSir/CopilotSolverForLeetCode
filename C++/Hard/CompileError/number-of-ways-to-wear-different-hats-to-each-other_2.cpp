class Solution {
public:
    int numberWays(vector<vector<int>>& hats) {
        
        int n = hats.size();
        vector<vector<int>> hat2people(41, vector<int>());
        for (int i = 0; i < n; i++) {
            for (int hat : hats[i]) {
                hat2people[hat].push_back(i);
            }
        }
        vector<vector<int>> dp(1 << n, vector<int>(41, -1));
        return dfs(0, 1, hat2people, dp);
    }
};