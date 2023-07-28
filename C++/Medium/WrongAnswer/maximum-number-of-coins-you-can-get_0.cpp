class Solution {
public:
    int maxCoins(vector<int>& piles) {
        
        sort(piles.begin(), piles.end(), greater<int>());
        int res = 0;
        for (int i = 1; i < piles.size(); i += 2) {
            res += piles[i];
        }
        return res;
    }
};