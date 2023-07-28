class Solution {
public:
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        
        int n = price.size();
        int m = special.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += price[i] * needs[i];
        }
        for (int i = 0; i < m; i++) {
            bool flag = true;
            for (int j = 0; j < n; j++) {
                if (needs[j] < special[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int j = 0; j < n; j++) {
                    needs[j] -= special[i][j];
                }
                res = min(res, shoppingOffers(price, special, needs) + special[i][n]);
                for (int j = 0; j < n; j++) {
                    needs[j] += special[i][j];
                }
            }
        }
        return res;
    }
};