class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        
        int n = s.size();
        vector<int> forward(n, 0);
        vector<int> backward(n, 0);
        for (int i = 0; i < shifts.size(); i++) {
            forward[shifts[i][0]] += shifts[i][2];
            backward[shifts[i][1]] += shifts[i][2];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += forward[i];
            s[i] = (s[i] - 'a' + sum) % 26 + 'a';
            sum -= backward[i];
        }
        return s;
    }
};