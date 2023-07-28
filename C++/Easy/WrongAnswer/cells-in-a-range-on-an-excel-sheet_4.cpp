class Solution {
public:
    vector<string> cellsInRange(string s) {
        
        int i = 0;
        while (s[i] >= 'A' && s[i] <= 'Z') i++;
        int c1 = 0, c2 = 0, r1 = 0, r2 = 0;
        for (int j = 0; j < i; j++) c1 = c1 * 26 + (s[j] - 'A' + 1);
        for (i++; i < s.length(); i++) r1 = r1 * 10 + (s[i] - '0');
        i = 0;
        while (s[i] != ':') i++;
        for (int j = 0; j < i; j++) c2 = c2 * 26 + (s[j] - 'A' + 1);
        for (i++; i < s.length(); i++) r2 = r2 * 10 + (s[i] - '0');
        vector<string> res;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
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