class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        int n = piles.size();
        int m = piles[0].size();
        vector<int> coins;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                coins.push_back(piles[i][j]);
            }
        }
        sort(coins.begin(), coins.end());
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += coins[coins.size() - i * 2];
        }
        return ans;
    }
};