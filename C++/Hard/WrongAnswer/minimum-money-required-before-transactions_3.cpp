class Solution {
public:
    long long minimumMoney(vector<vector<int>>& transactions) {
        
        long long ans = 0;
        sort(transactions.begin(), transactions.end(), [](vector<int> a, vector<int> b) {
            return a[0] - a[1] > b[0] - b[1];
        });
        for (int i = 0; i < transactions.size(); i++) {
            ans += transactions[i][0];
        }
        long long sum = 0;
        for (int i = 0; i < transactions.size(); i++) {
            sum += transactions[i][1];
            ans = min(ans, sum);
        }
        return ans;
    }
};