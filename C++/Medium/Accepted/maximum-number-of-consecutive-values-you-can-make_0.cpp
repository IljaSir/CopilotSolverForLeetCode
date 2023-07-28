class Solution {
public:
    int getMaximumConsecutive(vector<int>& coins) {
        
        sort(coins.begin(), coins.end());
        int res = 0;
        for (int i = 0; i < coins.size() && coins[i] <= res + 1; i++) {
            res += coins[i];
        }
        return res + 1;
    }
};