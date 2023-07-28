class Solution {
public:
    int appendCharacters(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        int i = n - 1;
        int j = m - 1;
        int ans = 0;
        while (i >= 0 && j >= 0) {
            if (s[i] == t[j]) {
                i--;
                j--;
            } else {
                ans++;
                i--;
            }
        }
        if (j >= 0) ans += j + 1;
        return ans;
    }
};