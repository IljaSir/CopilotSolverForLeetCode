class Solution {
public:
    long long minimumMoney(vector<vector<int>>& transactions) {
        
        long long sum = 0;
        for (auto &x : transactions) {
            sum += x[0];
        }
        sort(transactions.begin(), transactions.end(), [](auto &a, auto &b) {
            return a[0] - a[1] < b[0] - b[1];
        });
        long long ret = 0;
        for (auto &x : transactions) {
            if (sum < x[0]) {
                ret += x[0] - sum;
                sum = x[0];
            }
            sum -= x[1];
        }
        return ret;
    }
};