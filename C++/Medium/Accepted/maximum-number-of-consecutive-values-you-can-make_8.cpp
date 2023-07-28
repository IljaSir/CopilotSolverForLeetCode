class Solution {
public:
    int getMaximumConsecutive(vector<int>& coins) {
        
        int sum = 0;
        sort(coins.begin(), coins.end());
        for(int i = 0; i < coins.size() && coins[i] <= sum + 1; ++i)
            sum += coins[i];
        return sum + 1;
    }
};