class Solution {
public:
    char findTheDifference(string s, string t) {
        
        int n = s.size(), m = t.size();
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += s[i];
        }
        for (int i = 0; i < m; i++) {
            sum2 += t[i];
        }
        return sum2 - sum1;
    }
};