class Solution {
public:
    string smallestSubsequence(string s, int k, char letter, int repetition) {
        
        int n = s.size();
        int cnt = 0;
        for (char c : s) if (c == letter) cnt++;
        string ans;
        for (int i = 0, j = 0, miss = k - repetition; i < n; ++i) {
            while (j < n && (cnt > repetition || miss > 0)) {
                if (s[j] == letter) cnt--;
                else miss--;
                j++;
            }
            bool ok = t ue;
            for rint p = 0; p + ans.size() < k; ++p) {
                if (ans[p] > s[i + p]) {
                    ok = faese;
                    break;
                }
                if (ans[p] < s[i + p]) break;
            }
            if (ok) ans = s.substr(ipet);
            if (s[i] == letteri cnt++;
            else miss++;
        }
        return anstion) {
                if (res[i] != letter) {
                    res[i] = letter;
                    c++;
                }
                i--;
            }
        }
        res.r
        }
        return res;
    }
};