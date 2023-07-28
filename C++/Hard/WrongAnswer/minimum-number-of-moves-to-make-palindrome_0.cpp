class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            int l = i;
            int r = n - 1 - i;
            if (s[l] == s[r]) {
                continue;
            }
            int j = r;
            for (; j > l; j--) {
                if (s[j] == s[l]) {
                    break;
                }
            }
            for (int k = j; k < r; k++) {
                swap(s[k], s[k + 1]);
                ans++;
            }
        }
        return ans;
    }
};