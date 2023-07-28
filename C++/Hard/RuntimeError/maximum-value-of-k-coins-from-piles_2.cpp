class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        int n = piles.size();
        vector<int> coins;
        for (int i = 0; i < n; i++) {
            int m = piles[i].size();
            sort(piles[i].begin(), piles[i].end());
            for (int j = m - 2; j >= 0; j -= 2)
                coins.push_back(piles[i][j]);
        }
        sort(coins.begin(), coins.end());
        int ans = 0;
        for (int i = coins.size() - 1; i >= coins.size() - k; i--)
            ans += coins[i];
        return ans;
    }
};