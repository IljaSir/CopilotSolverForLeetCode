class Solution {
public:
    int minFlips(string s) {
        
        int n = s.size();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] != s[i % 2]) ++res;
        }
        return min(res, n - res);
    }
};