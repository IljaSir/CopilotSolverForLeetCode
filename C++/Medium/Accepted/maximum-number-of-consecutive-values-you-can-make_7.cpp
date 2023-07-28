class Solution {
public:
    int getMaximumConsecutive(vector<int>& coins) {
        
        int n = coins.size();
        sort(coins.begin(), coins.end());
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (coins[i] > res + 1) break;
            res += coins[i];
        }
        return res + 1;
    }
};