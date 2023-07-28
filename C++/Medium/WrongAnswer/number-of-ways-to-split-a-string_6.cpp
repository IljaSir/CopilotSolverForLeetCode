class Solution {
public:
    int numWays(string s) {
        
        long long n = s.size();
        long long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += s[i] - '0';
        }
        if (sum == 0) {
            return (n - 1) * (n - 2) / 2 % 1000000007;
        }
        if (sum % 3 != 0) {
            return 0;
        }
        long long target = sum / 3;
        long long count = 0;
        long long ways = 1;
        for (int i = 0; i < n; ++i) {
            count += s[i] - '0';
            if (count == target) {
                ++ways;
            }
            if (count == target * 2) {
                return (ways - 1) * (ways - 1) % 1000000007;
            }
        }
        return 0;
    }
};