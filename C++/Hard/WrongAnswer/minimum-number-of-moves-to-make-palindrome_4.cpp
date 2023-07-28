class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int n = s.size();
        int l = 0, r = n - 1;
        int cnt = 0;
        while(l < r) {
            if(s[l] != s[r]) {
                cnt++;
            }
            l++;
            r--;
        }
        return cnt;
    }
};