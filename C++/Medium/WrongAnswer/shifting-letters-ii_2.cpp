class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        
        int n = s.size();
        vector<int> sum(n, 0);
        sum[n - 1] = shifts[n - 1][2];
        for (int i = n - 2; i >= 0; --i) {
            sum[i] = sum[i + 1] + shifts[i][2];
        }
        for (int i = 0; i < n; ++i) {
            int pos = s[i] - 'a';
            int shift = sum[i];
            if (shifts[i][2] == 1) {
                pos = (pos + shift) % 26;
            } else {
                pos = (pos - shift + 26) % 26;
            }
            s[i] = 'a' + pos;
        }
        return s;
    }
};