class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        string ans = s;
        int n = s.size();
        for (int i = 0; i < n; i++) {
            string t = s.substr(i) + s.substr(0, i);
            for (int j = 0; j < n; j += 2) {
                t[j] = (t[j] - '0' + a) % 10 + '0';
            }
            ans = min(ans, t);
            ans = min(ans, findLexSmallestString(t, a, b));
        }
        return ans;
    }
};