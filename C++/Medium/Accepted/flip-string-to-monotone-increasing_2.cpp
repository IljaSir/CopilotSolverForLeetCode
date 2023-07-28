class Solution {
public:
    int minFlipsMonoIncr(string s) {
        
        int n = s.size();
        vector<int> pre(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            pre[i] = pre[i-1] + (s[i-1] == '1');
        }
        int ans = INT_MAX;
        for (int i = 0; i <= n; ++i) {
            ans = min(ans, pre[i] + n-i-(pre[n]-pre[i]));
        }
        return ans;
    }
};