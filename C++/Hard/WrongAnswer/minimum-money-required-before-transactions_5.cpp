class Solution {
public:
    long long minimumMoney(vector<vector<int>>& transactions) {
        
        long long sum = 0;
        for (auto &t : transactions) {
            sum += t[0];
        }
        sort(transactions.begin(), transactions.end(), [](auto &a, auto &b) {
            return a[0] - a[1] < b[0] - b[1];
        });
        long long minSum = 0;
        for (auto &t : transactions) {
            if (minSum < t[0]) {
                minSum = t[0];
            }
            minSum -= t[1];
        }
        return sum - minSum;
    }
};