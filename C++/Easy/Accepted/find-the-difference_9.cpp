class Solution {
public:
    char findTheDifference(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        if (n == 0) return t[0];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += (t[i] - s[i]);
        }
        sum += t[m - 1];
        return (char)sum;
    }
};