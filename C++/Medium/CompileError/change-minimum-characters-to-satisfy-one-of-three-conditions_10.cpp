class Solution {
public:
    int minCharacters(string a, string b) {
        
        int n = a.size(), m = b.size();
        vector<int> cnta(26, 0), cntb(26, 0);
        for (auto c : a) ++cnta[c - 'a'];
        for (auto c : b) ++cntb[c - 'a'];
        int ans = n + m;
        for (int i = 0; i < 25; ++i) {
            ans = min(ans, n + m - cnta[i] - cntb[i]);
            ans = min(ans, n - cnta[i] + cntb[i]);
            ans = min(ans, m - cntb[i] + cnta[i]
        }
        int ans = a.size() + b.size();
        for (int i = 0; i < 26; ++i) {
            int tmp = 0;
            for (int j = 0; j < 26; ++j) {
                if (j < i) {
                    tmp += ca[j] + cb[j];
                } else if (j > i) {
                    tmp += ca[j] + cb[j];
                }
            }
            ans = min(ans, tmp);
        }
        for (int i = 0; i < 26; ++i) {
            int tmp = 0;
            for (int j = 0; j < 26; ++j) {
                if (j < i) {
                    tmp += ca[j] + cb[j];
                } else if (j > i) {
                    tmp += ca[j] + cb[j];
                }
            }
            ans = min(ans, tmp);
        }
        for (int i = 0; i < 26; ++i) {
            int tmp = 0;
            for (int j = 0; j < 26; ++j) {
                if (j < i) {
                    tmp += ca[j] + cb[j];
                } else if (j > i) {
                    tmp += ca[j] + cb[j];
                }
            }
            ans = min(ans, tmp);
        }
        return ans;
    }
};