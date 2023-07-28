class Solution {
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        
        sort(batteries.begin(), batteries.end());
        long long res = 0;
        for (int i = 0; i < n; i++) {
            res = max(res, (long long)batteries[i] * (n - i));
        }
        return res;
    }
};