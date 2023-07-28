class Solution {
public:
    vector<string> cellsInRange(string s) {
        
        vector<string> res;
        int i = 0;
        while (s[i] >= 'A' && s[i] <= 'Z') {
            ++i;
        }
        int c1 = 0, c2 = 0;
        for (int j = 0; j < i; ++j) {
            c1 = c1 * 26 + s[j] - 'A';
        }
        for (int j = i + 1; j < s.size(); ++j) {
            c2 = c2 * 10 + s[j] - '0';
        }
        i = 0;
        while (s[i] != ':') {
            ++i;
        }
        int r1 = 0, r2 = 0;
        for (int j = i + 1; j < s.size(); ++j) {
            r2 = r2 * 10 + s[j] - '0';
        }
        for (int j = i - 1; j >= 0; --j) {
            r1 = r1 * 10 + s[j] - '0';
        }
        for (int i = r1; i <= r2; ++i) {
            int j = c1;
            while (j > 0) {
                int k = j % 26;
                if (k == 0) {
                    res.push_back('Z');
                    j = j / 26 - 1;
                } else {
                    res.push_back('A' + k - 1);
                    j /= 26;
                }
            }
            string t = to_string(i);
            reverse(t.begin(), t.end());
            res.push_back(t);
        }
        return res;
    }
};