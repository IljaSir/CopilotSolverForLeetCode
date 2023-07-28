class Solution {
public:
    int getMaximumConsecutive(vector<int>& coins) {
        
        int ans = 0;
        sort(coins.begin(), coins.end());
        for (int i = 0; i < coins.size() && coins[i] <= ans + 1; ++i) {
            ans += coins[i];
        }
        return ans + 1;
    }
};