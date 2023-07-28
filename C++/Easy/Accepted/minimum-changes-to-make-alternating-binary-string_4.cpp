class Solution {
public:
    int minOperations(string s) {
        
        int n = s.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((i % 2 == 0 && s[i] == '0') || (i % 2 == 1 && s[i] == '1')) res++;
        }
        return min(res, n - res);
    }
};