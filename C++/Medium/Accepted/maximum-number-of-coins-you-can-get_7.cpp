class Solution {
public:
    int maxCoins(vector<int>& piles) {
        
        sort(piles.begin(), piles.end());
        int n = piles.size();
        int i = n - 2;
        int res = 0;
        while (i >= n / 3) {
            res += piles[i];
            i -= 2;
        }
        return res;
    }
};