class Solution {
public:
    int countAsterisks(string s) {
        
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] == '*') {
                ans++;
            }
            if (s[i] == '|') {
                i += 2;
            }
        }
        return ans;
    }
};