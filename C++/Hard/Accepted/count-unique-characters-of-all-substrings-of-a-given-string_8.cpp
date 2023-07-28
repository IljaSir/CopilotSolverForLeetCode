class Solution {
public:
    int uniqueLetterString(string s) {
        
        vector<vector<int>> v(26, vector<int>(2, -1));
        int ans = 0;
        for (int i = 0; i < s.size(); ++i) {
            int id = s[i] - 'A';
            ans += (i - v[id][1]) * (v[id][1] - v[id][0]);
            v[id][0] = v[id][1];
            v[id][1] = i;
        }
        for (int i = 0; i < 26; ++i) {
            ans += (s.size() - v[i][1]) * (v[i][1] - v[i][0]);
        }
        return ans;
    }
};