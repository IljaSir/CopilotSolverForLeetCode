class Solution {
public:
    int countAsterisks(string s) {
        
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '*') {
                ans++;
            } else if (s[i] == '|') {
                while (i < n && s[i] == '|') {
                    i++;
                }
                i--;
            }
        }
        return ans;
    }
};