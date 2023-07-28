class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        
        int n = s.length();
        vector<int> sum(n+1, 0);
        for (auto &sh : shifts) {
            sum[sh[0]] += (sh[2] == 1 ? 1 : -1);
            sum[sh[1]+1] -= (sh[2] == 1 ? 1 : -1);
        }
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            cnt += sum[i];
            s[i] = (s[i] - 'a' + cnt) % 26 + 'a';
        }
        return s;
    }
};