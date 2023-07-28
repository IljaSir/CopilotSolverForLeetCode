class Solution {
public:
    int minimumScore(string s, string t) {
        
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        int ans = m;
        while(i < n && j < m) {
            if (s[i] == t[j]) {
                ans = min(ans, m - j);
                j++;
            }
            i++;
        }
        return ans;
    }
};