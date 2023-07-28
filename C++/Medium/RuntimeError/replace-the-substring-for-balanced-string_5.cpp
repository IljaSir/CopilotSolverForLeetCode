class Solution {
public:
    int balancedString(string s) {
        
        int n = s.size(), count = n / 4;
        int q = 0, w = 0, e = 0, r = 0;
        for (char c : s) {
            if (c == 'Q') q++;
            if (c == 'W') w++;
            if (c == 'E') e++;
            if (c == 'R') r++;
        }
        int ans = n;
        for (int i = 0, j = 0; j < n; j++) {
            if (s[j] == 'Q') q--;
            if (s[j] == 'W') w--;
            if (s[j] == 'E') e--;
            if (s[j] == 'R') r--;
            while (q <= count && w <= count && e <= count && r <= count) {
                ans = min(ans, j - i + 1);
                if (s[i] == 'Q') q++;
                if (s[i] == 'W') w++;
                if (s[i] == 'E') e++;
                if (s[i] == 'R') r++;
                i++;
            }
        }
        return ans;
    }
};