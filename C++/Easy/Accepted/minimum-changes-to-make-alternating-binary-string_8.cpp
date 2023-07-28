class Solution {
public:
    int minOperations(string s) {
        
        int n = s.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] != (i % 2) + '0') {
                res++;
            }
        }
        return min(res, n - res);
    }
};