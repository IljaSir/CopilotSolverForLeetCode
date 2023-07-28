class Solution {
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        
        long long sum = 0;
        sort(batteries.begin(), batteries.end());
        for (int i = 0; i < n; i++) {
            sum += batteries[i];
        }
        long long result = 0;
        for (int i = 0; i < n; i++) {
            result = max(result, sum - batteries[i] * (n - i - 1));
        }
        return result;
    }
};