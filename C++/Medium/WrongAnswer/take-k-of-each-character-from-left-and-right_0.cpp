class Solution {
public:
    int takeCharacters(string s, int k) {
        
        int n = s.size();
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') a++;
            if (s[i] == 'b') b++;
            if (s[i] == 'c') c++;
        }
        if (a < k || b < k || c < k) return -1;
        int l = 0, r = n - 1;
        int la = 0, lb = 0, lc = 0;
        while (l < r) {
            if (s[l] == 'a') {
                la++;
                if (la == k) break;
            } else if (s[l] == 'b') {
                lb++;
                if (lb == k) break;
            } else {
                lc++;
                if (lc == k) break;
            }
            if (s[r] == 'a') {
                la++;
                if (la == k) break;
            } else if (s[r] == 'b') {
                lb++;
                if (lb == k) break;
            } else {
                lc++;
                if (lc == k) break;
            }
            l++;
            r--;
        }
        if (l == r) {
            if (s[l] == 'a') la++;
            if (s[l] == 'b') lb++;
            if (s[l] == 'c') lc++;
        }
        if (la < k) la = k - la;
        if (lb < k) lb = k - lb;
        if (lc < k) lc = k - lc;
        return l + 1 + n - r + la + lb + lc;
    }
};