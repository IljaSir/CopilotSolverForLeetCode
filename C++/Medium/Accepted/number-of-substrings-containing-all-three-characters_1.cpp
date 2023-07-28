class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int n = s.length();
        int a = 0, b = 0, c = 0;
        int i = 0;
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            if (s[j] == 'a') a++;
            else if (s[j] == 'b') b++;
            else c++;
            while (a > 0 && b > 0 && c > 0) {
                if (s[i] == 'a') a--;
                else if (s[i] == 'b') b--;
                else c--;
                i++;
            }
            ans += i;
        }
        return ans;
    }
};