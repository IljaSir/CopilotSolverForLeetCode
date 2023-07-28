class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        int n = s.size();
        vector<int> l(26, n), r(26, 0);
        for (int i = 0; i < n; i++) {
            l[s[i] - 'a'] = min(l[s[i] - 'a'], i);
            r[s[i] - 'a'] = max(r[s[i] - 'a'], i);
        }
        vector<int> v;
        for (int i = 0; i < 26; i++) {
            if (l[i] == n) continue;
            int x = l[i], y = r[i];
            for (int j = x; j < y; j++) {
                if (l[s[j] - 'a'] < x) {
                    x = -1;
                    break;
                }
                y = max(y, r[s[j] - 'a']);
            }
            if (x != -1) {
                v.push_back(x * n + y);
            }
        }
        sort(v.begin(), v.end());
        vector<string> res;
        int x = -1, y = -1;
        for (auto& p : v) {
            int a = p / n, b = p % n;
            if (a > y) {
                if (x != -1) {
                    res.push_back(s.substr(x, y - x + 1));
                }
                x = a;
            }
            y = max(y, b);
        }
        if (x != -1) {
            res.push_back(s.substr(x, y - x + 1));
        }
        return res;
    }
};