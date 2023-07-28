class Solution {
public:
    int minimumTime(string s) {
        
        int n = s.size();
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while (l < n && s[l] == '0') {
            l++;
        }
        while (r >= 0 && s[r] == '0') {
            r--;
        }
        if (l == n || r == -1) {
            return 0;
        }
        ans = 2;
        for (int i = l; i <= r; i++) {
            if (s[i] == '1') {
                ans += 2;
                while (i <= r && s[i] == '1') {
                    i++;
                }
                i--;
            }
        }
        return ans;
    }
};