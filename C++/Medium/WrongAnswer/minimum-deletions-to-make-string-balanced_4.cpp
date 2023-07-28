class Solution {
public:
    int minimumDeletions(string s) {
        
        int n = s.size();
        int a = 0, b = 0, res = n;
        for (int i = 0; i < n; ++i) {
            if (s[i] == 'a') a++;
        }
        for (int i = 0; i < n; ++i) {
            if (s[i] == 'a') a--;
            else b++;
            res = min(res, a + b);
        }
        return res;
    }
};