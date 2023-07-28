class Solution {
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        
        sort(batteries.begin(), batteries.end(), greater<int>());
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, (long long)batteries[i] * (n - i));
        }
        return ans;
    }
};