class Solution {
public:
    vector<string> cellsInRange(string s) {
        
        int i = 0;
        int c1 = 0;
        int c2 = 0;
        int r1 = 0;
        int r2 = 0;
        
        while (s[i] != ':') {
            c1 = 26 * c1 + (s[i] - 'A');
            i++;
        }
        i++;
        while (s[i] >= '0' && s[i] <= '9') {
            r1 = 10 * r1 + (s[i] - '0');
            i++;
        }
        i++;
        while (s[i] != ':') {
            c2 = 26 * c2 + (s[i] - 'A');
            i++;
        }
        i++;
        while (s[i] >= '0' && s[i] <= '9') {
            r2 = 10 * r2 + (s[i] - '0');
            i++;
        }
        
        vector<string> result;
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                string cell = "";
                while (c > 0) {
                    cell = (char)('A' + (c % 26)) + cell;
                    c = c / 26;
                }
                cell = cell + to_string(r);
                result.push_back(cell);
            }
        }
        return result;
    }
};