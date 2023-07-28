class Solution {
public:
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        
        int n = special.size();
        int m = price.size();
        int res = 0;
        for (int i = 0; i < m; ++i) {
            res += price[i] * needs[i];
        }
        for (int i = 0; i < n; ++i) {
            bool valid = true;
            for (int j = 0; j < m; ++j) {
                if (special[i][j] > needs[j]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                for (int j = 0; j < m; ++j) {
                    needs[j] -= special[i][j];
                }
                res = min(res, special[i][m] + shoppingOffers(price, special, needs));
                for (int j = 0; j < m; ++j) {
                    needs[j] += special[i][j];
                }
            }
        }
        return res;
    }
};