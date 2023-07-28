class Solution {
public:
    int maxCoins(vector<int>& piles) {
        
        int n = piles.size() / 3;
        sort(piles.begin(), piles.end(), greater<int>());
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += piles[2 * i + 1];
        }
        return res;
    }
};