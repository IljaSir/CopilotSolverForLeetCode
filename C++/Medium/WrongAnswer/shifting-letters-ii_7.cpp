class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        
        int n = s.length();
        vector<int> sum(n + 1, 0);
        for (auto& shift: shifts) {
            sum[shift[0]] += shift[2] == 0 ? -shift[1] - shift[0] : shift[1] - shift[0] + 1;
            sum[shift[1] + 1] -= shift[2] == 0 ? -shift[1] - shift[0] : shift[1] - shift[0] + 1;
        }
        for (int i = 1; i <= n; ++i) sum[i] += sum[i - 1];
        for (int i = 0; i < n; ++i) {
            int x = s[i] - 'a';
            x += sum[i];
            x = (x % 26 + 26) % 26;
            s[i] = x + 'a';
        }
        return s;
    }
};