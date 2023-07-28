class Solution {
public:
    int minimumDeletions(string s) {
        
        int n = s.size();
        int cnta = 0, cntb = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'b') {
                cntb++;
            }
        }
        int ans = cntb;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                cnta++;
            } else {
                cntb--;
            }
            ans = min(ans, cnta + cntb);
        }
        return ans;
    }
};