class Solution {
public:
    int kSimilarity(string s1, string s2) {
        
        int n = s1.length();
        vector<int> p(n);
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            if (s1[i] == s2[i]) {
                continue;
            }
            for (int j = i + 1; j < n; ++j) {
                if (s1[j] == s2[i]) {
                    swap(p[i], p[j]);
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (s1[i] == s2[i]) {
                continue;
            }
            if (p[i] == i) {
                continue;
            }
            swap(s1[i], s1[p[i]]);
            swap(p[i], p[p[i]]);
            ++res;
        }
        return res;
    }
};