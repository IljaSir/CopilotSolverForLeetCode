class Solution {
public:
    int minimumScore(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        vector<int> sc(n, 0);
        for (int i = 0; i < n; ++i) {
            if (s[i] != t[i]) {
                sc[i] = 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (sc[i] == 0) {
                continue;
            }
            int j = i;
            while (j < n && sc[j] == 1) {
                ++j;
            }
            ans = max(ans, j - i);
            i = j;
        }
        return ans;
    }
};