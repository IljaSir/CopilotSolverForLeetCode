class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        vector<int> coins;
        for (auto& p : piles) {
            for (auto c : p) {
                coins.push_back(c);
            }
        }
        sort(coins.begin(), coins.end());
        int sum = 0;
        for (int i = coins.size() - 2; i >= coins.size() - k; i -= 2) {
            sum += coins[i];
        }
        return sum;
    }
};