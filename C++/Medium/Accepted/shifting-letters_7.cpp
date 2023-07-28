class Solution {
public:
    string shiftingLetters(string s, vector<int>& shifts) {
        
        int n = s.length();
        vector<int> sum(n, 0);
        sum[n - 1] = shifts[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            sum[i] = (sum[i + 1] + shifts[i]) % 26;
        }
        for (int i = 0; i < n; ++i) {
            s[i] = 'a' + (s[i] - 'a' + sum[i]) % 26;
        }
        return s;
    }
};