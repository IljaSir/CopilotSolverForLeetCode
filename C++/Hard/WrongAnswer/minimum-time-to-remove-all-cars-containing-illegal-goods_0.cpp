class Solution {
public:
    int minimumTime(string s) {
        
        int n = s.size();
        int l = 0, r = n - 1;
        while (l < n && s[l] == '0') l++;
        while (r >= 0 && s[r] == '0') r--;
        if (l > r) return 0;
        int ans = r - l + 1;
        for (int i = l; i <= r; i++) {
            if (s[i] == '1') {
                ans += 2;
            }
        }
        return ans;
    }
};