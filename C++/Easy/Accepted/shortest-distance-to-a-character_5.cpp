class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        
        vector<int> ans;
        int n = s.length();
        int prev = -n;
        for (int i = 0; i < n; i++) {
            if (s[i] == c) prev = i;
            ans.push_back(i - prev);
        }
        prev = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == c) prev = i;
            ans[i] = min(ans[i], prev - i);
        }
        return ans;
    }
};