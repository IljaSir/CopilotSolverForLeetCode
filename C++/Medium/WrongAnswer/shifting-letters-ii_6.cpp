class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        
        int n = s.size();
        int i = n - 1;
        int sum = 0;
        while (i >= 0) {
            sum = (sum + shifts[i][2]) % 26;
            s[i] = (s[i] - 'a' + sum) % 26 + 'a';
            --i;
        }
        return s;
    }
};