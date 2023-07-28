class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        
        int n = s.length();
        int sum = 0;
        for (int i = n-1; i >= 0; --i) {
            sum += shifts[i][2] ? shifts[i][1] - shifts[i][0] + 1 : -(shifts[i][1] - shifts[i][0] + 1);
            s[i] = ((s[i]-'a') + sum) % 26;
            if (s[i] < 0) s[i] += 26;
            s[i] += 'a';
        }
        return s;
    }
};