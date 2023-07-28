class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        // 1. Sort coins
        sort(coins.begin(), coins.end());
        
        // 2. Find max number of coins
        int maxCoins = amount/coins[0];
        int minCoins = amount/coins[coins.size()-1];
        
        // 3. Try all possible combinations of coins
        vector<int> currCombination;
        int minCombination = maxCoins+1;
        coinChange(coins, amount, 0, currCombination, minCombination);
        
        if (minCombination == maxCoins+1) {
            return -1;
        }
        return minCombination;
    }
    
    void coinChange(vector<int>& coins, int amount, int coinIndex, vector<int>& currCombination, int& minCombination) {
        //cout << "amount: " << amount << " coinIndex: " << coinIndex << " currCombination: " << currCombination.size() << " minCombination: " << minCombination << endl;
        
        // 1. Check if we have a valid combination
        if (amount == 0) {
            if (currCombination.size() < minCombination) {
                minCombination = currCombination.size();
            }
            return;
        }
        
        // 2. Check if we have an invalid combination
        if (currCombination.size() >= minCombination) {
            return;
        }
        
        // 3. Check if we have a combination that exceeds the amount
        if (amount < 0) {
            return;
        }
        
        // 4. Try all possible combinations
        for (int i = coinIndex; i < coins.size(); i++) {
            //cout << "i: " << i << endl;
            currCombination.push_back(coins[i]);
            coinChange(coins, amount-coins[i], i, currCombination, minCombination);
            currCombination.pop_back();
        }
    }
};