class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        
        int maxWealth = 0;
        for (auto &account : accounts) {
            int wealth = accumulate(account.begin(), account.end(), 0);
            maxWealth = max(maxWealth, wealth);
        }
        return maxWealth;
    }
};