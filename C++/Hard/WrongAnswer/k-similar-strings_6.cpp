class Solution {
public:
    int kSimilarity(string s1, string s2) {
        
        int n = s1.size();
        vector<int> f(n, 0);
        vector<int> g(n, 0);
        for (int i = 0; i < n; ++i) {
            f[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            int j = 0;
            for (; j < n; ++j) {
                if (s1[i] == s2[j]) {
                    break;
                }
            }
            g[i] = j;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            for (; j < n; ++j) {
                if (f[j] == g[j]) {
                    break;
                }
            }
            if (j == n) {
                return ans + 1;
            }
            if (f[j] == g[i]) {
                swap(f[j], f[i]);
                ++ans;
            }
        }
        return ans;
    }
};