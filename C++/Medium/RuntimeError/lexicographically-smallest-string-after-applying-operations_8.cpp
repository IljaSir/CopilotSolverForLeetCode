class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        string ans = s;
        for (int i = 0; i < s.length(); i++) {
            string t = s;
            for (int j = i; j < t.length(); j += b) {
                t[j] = (t[j] - '0' + a) % 10 + '0';
            }
            ans = min(ans, t);
            ans = min(ans, findLexSmallestString(t, a, b));
        }
        return ans;
    }
};