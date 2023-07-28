class Solution {
public:
    char findTheDifference(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        if (n == 0) {
            return t[0];
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += s[i];
        }
        for (int i = 0; i < m; i++) {
            sum2 += t[i];
        }
        return (char)(sum2 - sum1);
    }
};