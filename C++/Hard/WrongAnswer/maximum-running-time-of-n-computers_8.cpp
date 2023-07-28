class Solution {
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        
        int m = batteries.size();
        sort(batteries.begin(), batteries.end());
        long long result = 0;
        for (int i = 0; i < n; i++) {
            result += batteries[i];
        }
        for (int i = n; i < m; i++) {
            long long t = result - batteries[i - n] + batteries[i];
            result = min(result, t);
        }
        return result;
    }
};