class Solution {
public:
    long long minimumMoney(vector<vector<int>>& transactions) {
        
        sort(transactions.begin(), transactions.end(), [](const vector<int>& x, const vector<int>& y) {
            return x[0] - x[1] > y[0] - y[1];
        });
        long long res = 0;
        for (auto& t : transactions) {
            res += t[0] - t[1];
            res = max(res, (long long)t[0]);
        }
        return res;
    }
};