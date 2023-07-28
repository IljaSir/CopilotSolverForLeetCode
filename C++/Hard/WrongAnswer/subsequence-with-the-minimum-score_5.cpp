class Solution {
public:
    int minimumScore(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        int ans = 0;
        int i = 0;
        int j = 0;
        int left = -1;
        int right = -1;
        while (i < n && j < m) {
            if (s[i] == t[j]) {
                if (left == -1) {
                    left = i;
                }
                right = i;
                ++i;
                ++j;
            } else {
                ++i;
            }
        }
        if (j == m) {
            ans = right - left + 1;
        }
        return ans;
    }
};