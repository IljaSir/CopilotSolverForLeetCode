class Solution {
public:
    long long minimumMoney(vector<vector<int>>& transactions) {
        
        long long res = 0;
        for (auto& t : transactions) {
            res += t[0];
        }
        sort(transactions.begin(), transactions.end(), [](const auto& a, const auto& b) {
            return a[0] - a[1] < b[0] - b[1];
        });
        for (int i = 0; i < transactions.size(); ++i) {
            if (res < transactions[i][0]) {
                res = transactions[i][0];
            }
            res -= transactions[i][0] - transactions[i][1];
        }
        return res;
    }
};