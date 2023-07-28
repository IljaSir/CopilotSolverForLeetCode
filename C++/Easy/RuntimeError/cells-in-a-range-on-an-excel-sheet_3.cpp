class Solution {
public:
    vector<string> cellsInRange(string s) {
        
        int i = 0;
        while (s[i] >= 'A' && s[i] <= 'Z') {
            i++;
        }
        int c1 = 0;
        for (int j = 0; j < i; j++) {
            c1 = c1 * 26 + (s[j] - 'A' + 1);
        }
        int r1 = stoi(s.substr(i));
        i++;
        while (s[i] >= 'A' && s[i] <= 'Z') {
            i++;
        }
        int c2 = 0;
        for (int j = i - 1; j >= 0; j--) {
            c2 = c2 * 26 + (s[j] - 'A' + 1);
        }
        int r2 = stoi(s.substr(i));
        vector<string> res;
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                string col = "";
                int c3 = c;
                while (c3 > 0) {
                    int rem = c3 % 26;
                    if (rem == 0) {
                        rem = 26;
                    }
                    col = (char)(rem - 1 + 'A') + col;
                    c3 = (c3 - rem) / 26;
                }
                res.push_back(col + to_string(r));
            }
        }
        return res;
    }
};