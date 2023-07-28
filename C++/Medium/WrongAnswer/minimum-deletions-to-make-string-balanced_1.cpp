class Solution {
public:
    int minimumDeletions(string s) {
        
        int n = s.size();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'b') {
                b++;
            }
        }
        int res = b;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                a++;
            } else {
                b--;
            }
            res = min(res, a+b);
        }
        return res;
    }
};