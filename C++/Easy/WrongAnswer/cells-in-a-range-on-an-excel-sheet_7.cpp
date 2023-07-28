class Solution {
public:
    vector<string> cellsInRange(string s) {
        
        vector<string> res;
        int i = 0;
        int j = 0;
        while (s[j] != ':') {
            ++j;
        }
        string s1 = s.substr(0, j);
        string s2 = s.substr(j + 1);
        int n1 = s1.size();
        int n2 = s2.size();
        int c1 = 0;
        int r1 = 0;
        int c2 = 0;
        int r2 = 0;
        for (int i = 0; i < n1; ++i) {
            if (s1[i] >= 'A' && s1[i] <= 'Z') {
                c1 = c1 * 26 + s1[i] - 'A' + 1;
            }
            else {
                r1 = r1 * 10 + s1[i] - '0';
            }
        }
        for (int i = 0; i < n2; ++i) {
            if (s2[i] >= 'A' && s2[i] <= 'Z') {
                c2 = c2 * 26 + s2[i] - 'A' + 1;
            }
            else {
                r2 = r2 * 10 + s2[i] - '0';
            }
        }
        for (int i = r1; i <= r2; ++i) {
            for (int j = c1; j <= c2; ++j) {
                string t = "";
                int k = j;
                while (k > 0) {
                    t = char((k - 1) % 26 + 'A') + t;
                    k = (k - 1) / 26;
                }
                t += to_string(i);
                res.push_back(t);
            }
        }
        return res;
    }
};