class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        int n = piles.size();
        vector<int> coins;
        for (int i = 0; i < n; i++) {
            int m = piles[i].size();
            for (int j = 0; j < m; j++) {
                coins.push_back(piles[i][j]);
            }
        }
        sort(coins.begin(), coins.end());
        int ans = 0;
        for (int i = coins.size() - 2; i >= coins.size() - k; i -= 2) {
            ans += coins[i];
        }
        return ans;
    }
};