class Solution {
public:
    int getMaxRepetitions(string s1, int n1, string s2, int n2) {
        
        int n = s1.size(), m = s2.size();
        vector<int> next(m, 0), cnt(m, 0);
        for (int i = 0, j = 0; i < n; ++i) {
            for (int k = 0; k < m; ++k) {
                if (s1[(i + k) % n] == s2[k]) {
                    ++next[j];
                }
            }
            ++j;
            j %= m;
        }
        int ans = 0;
        for (int i = 0, j = 0; i < n1; ++i) {
            ans += next[j];
            ++j;
            j %= m;
        }
        return ans / (n2 * m);
    }
};