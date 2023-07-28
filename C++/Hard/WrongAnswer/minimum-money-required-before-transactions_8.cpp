class Solution {
public:
    long long minimumMoney(vector<vector<int>>& transactions) {
        
        long long sum = 0;
        sort(transactions.begin(), transactions.end());
        for (auto x : transactions) {
            sum += x[0];
        }
        long long ans = sum;
        for (int i = 0; i < transactions.size(); ++i) {
            sum -= transactions[i][0];
            ans = min(ans, sum + transactions[i][1]);
        }
        return ans;
    }
};