class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        
        vector<int> ans(s.size(), 0);
        int n = s.size();
        int last = -n;
        for (int i = 0; i < n; i++) {
            if (s[i] == c) last = i;
            ans[i] = i - last;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == c) last = i;
            ans[i] = min(ans[i], abs(i - last));
        }
        return ans;
    }
};