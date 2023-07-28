class Solution {
public:
    int minFlipsMonoIncr(string s) {
        
        int n = s.size();
        vector<int> ones(n, 0);
        ones[0] = s[0] - '0';
        for (int i = 1; i < n; i++) {
            ones[i] = ones[i - 1] + s[i] - '0';
        }
        int ans = ones[n - 1];
        for (int i = 0; i < n; i++) {
            int cur = ones[i] + (n - 1 - i) - (ones[n - 1] - ones[i]);
            ans = min(ans, cur);
        }
        return ans;
    }
};