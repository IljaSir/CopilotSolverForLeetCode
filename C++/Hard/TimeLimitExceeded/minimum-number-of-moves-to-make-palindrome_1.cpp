class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int l = 0, r = s.size() - 1;
        int count = 0;
        while (l < r) {
            if (s[l] != s[r]) {
                if (s[l] < s[r]) {
                    s[l+1] = s[l+1] + s[l];
                    s[l] = s[l+1] - s[l];
                    s[l+1] = s[l+1] - s[l];
                    count++;
                } else {
                    s[r-1] = s[r-1] + s[r];
                    s[r] = s[r-1] - s[r];
                    s[r-1] = s[r-1] - s[r];
                    count++;
                }
            } else {
                l++;
                r--;
            }
        }
        return count;
    }
};