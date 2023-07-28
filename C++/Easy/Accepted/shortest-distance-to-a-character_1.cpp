class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        
        int n = s.size();
        vector<int> ans(n, n);
        for (int i = 0; i < n; i++) {
            if (s[i] == c) ans[i] = 0;
            else {
                if (i > 0) ans[i] = min(ans[i], ans[i - 1] + 1);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) ans[i] = min(ans[i], ans[i + 1] + 1);
        }
        return ans;
    }
};