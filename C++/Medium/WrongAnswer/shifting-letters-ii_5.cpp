class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        
        int n = s.size();
        vector<int> sum(n);
        sum[n-1] = shifts[n-1][2];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i+1] + shifts[i][2];
        }
        for (int i = 0; i < n; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            if (start < n) {
                s[start] = (s[start] - 'a' + sum[start]) % 26 + 'a';
            }
            if (end + 1 < n) {
                s[end+1] = (s[end+1] - 'a' - sum[end+1]) % 26 + 'a';
            }
        }
        return s;
    }
};