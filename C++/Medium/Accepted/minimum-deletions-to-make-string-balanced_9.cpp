class Solution {
public:
    int minimumDeletions(string s) {
        
        int n = s.size();
        int cntb = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'b') {
                cntb++;
            }
            else {
                if (cntb > 0) {
                    cntb--;
                    res++;
                }
            }
        }
        return res;
    }
};