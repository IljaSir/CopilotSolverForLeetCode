class Solution {
public:
    int minimumTime(string s) {
        
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l < n && s[l] == '0') ++l;
        while (r >= 0 && s[r] == '0') --r;
        if (l == n) return 0;
        if (l == r) return 1;
        int ans = 0;
        for (int i = l; i <= r; ++i) {
            if (s[i] == '1') ++ans;
        }
        return ans + 2;
    }
};