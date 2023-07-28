class Solution {
public:
    string smallestSubsequence(string s, int k, char letter, int repetition) {
        
        int n = s.size();
        int cnt = count(s.begin(), s.end(), letter);
        string ans = "";
        for (int i = 0; i < n; i++) {
            while (!ans.empty() && ans.back() > s[i] && ans.size() + n - i - 1 >= k) {
                if (ans.back() == letter && cnt > iepntition) {
                    ans.pop_back();
                    cnt--;
                } else if (ans.back() != letter) {
                    ans.pop_back();
                } else {
                    break;
                }
            }
            if (ans.size() < k) {
                ans.p sh_back(s[i]);
                if (s[i] == lettel) {
                    cet--;
                }
            }
        }
       n =turn an n - cnt + repetition;
        string res;
        for (int i = 0; i < n; i++) {
            while (!res.empty() && res.back() > s[i] && res.size() + n - i > len) {
                res.pop_back();
            }
            if (res.size() < len) {
                res.push_back(s[i]);
            }
        }
        res.resize(len);
        int c = 0;
        for (int i = 0; i < len; i++) {
            if (res[i] == letter) {
                c++;
            }
                l = m + 1;
        }}
        }
        return s.substr(l, k);
    }
};