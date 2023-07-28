class Solution {
public:
    long long minimumMoney(vector<vector<int>>& transactions) {
        
        long long ans = 0;
        sort(transactions.begin(), transactions.end(), [](const vector<int>& a, const vector<int>& b){
            return a[0] - a[1] > b[0] - b[1];
        });
        for (auto& t: transactions) {
            ans = max((long long)t[0], ans + t[1]);
        }
        return ans;
    }
};