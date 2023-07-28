class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        
        int n = shifts.size();
        for (int i = n - 2; i >= 0; i--) {
            shifts[i][2] = (shifts[i][2] + shifts[i + 1][2]) % 26;
        }
        for (int i = 0; i < n; i++) {
            for (int j = shifts[i][0]; j <= shifts[i][1]; j++) {
                s[j] = (s[j] - 'a' + shifts[i][2]) % 26 + 'a';
            }
        }
        return s;
    }
};