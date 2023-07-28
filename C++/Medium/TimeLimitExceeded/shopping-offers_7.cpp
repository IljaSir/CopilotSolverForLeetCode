class Solution {
public:
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        
        int n = needs.size();
        int m = special.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += price[i] * needs[i];
        }
        for (int i = 0; i < m; i++) {
            bool flag = false;
            for (int j = 0; j < n; j++) {
                if (special[i][j] > needs[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            for (int j = 0; j < n; j++) {
                needs[j] -= special[i][j];
            }
            ans = min(ans, shoppingOffers(price, special, needs) + special[i][n]);
            for (int j = 0; j < n; j++) {
                needs[j] += special[i][j];
            }
        }
        return ans;
    }
};