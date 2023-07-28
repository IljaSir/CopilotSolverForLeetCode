class Solution {
public:
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        
        int n = price.size();
        vector<int> offer(n, 0);
        for (auto& s : special) {
            for (int i = 0; i < n; ++i) {
                offer[i] += s[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += price[i] * needs[i];
        }
        return dfs(price, special, needs, sum);
    }
    int dfs(vector<int>& price, vector<vector<int>>& special, vector<int>& needs, int sum) {
        int n = price.size();
        int minSum = sum;
        for (auto& s : special) {
            bool flag = true;
            for (int i = 0; i < n; ++i) {
                if (needs[i] < s[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int i = 0; i < n; ++i) {
                    needs[i] -= s[i];
                }
                minSum = min(minSum, dfs(price, special, needs, sum - s[n]));
                for (int i = 0; i < n; ++i) {
                    needs[i] += s[i];
                }
            }
        }
        return minSum;
    }
};