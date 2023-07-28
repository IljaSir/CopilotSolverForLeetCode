class Solution {
public:
    int getMaximumConsecutive(vector<int>& coins) {
        
        sort(coins.begin(), coins.end());
        int ans = 0;
        for (int i = 0; i < coins.size(); ++i) {
            if (coins[i] > ans + 1) break;
            ans += coins[i];
        }
        return ans + 1;
    }
};