class Solution {
public:
    bool canBeValid(string s, string locked) {
        
        int n = s.size();
        vector<int> open(n), close(n);
        for (int i = 0; i < n; ++i) {
            open[i] = (s[i] == '(');
            close[i] = (s[i] == ')');
            if (i) {
                open[i] += open[i - 1];
                close[i] += close[i - 1];
            }
        }
        int o = 0, c = 0;
        for (int i = 0; i < n; ++i) {
            if (locked[i] == '0') {
                s[i] = '(';
                ++o;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (locked[i] == '0') {
                s[i] = ')';
                ++c;
            }
            if (o < open[i] || c < close[i]) {
                return false;
            }
        }
        return true;
    }
};