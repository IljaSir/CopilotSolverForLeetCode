class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int n = s.size();
        int l = 0, r = n-1;
        int ans = 0;
        while(l < r){
            if(s[l] != s[r]){
                ans++;
                if(s[l] > s[r]){
                    char c = s[l];
                    s[l] = s[r];
                    s[r] = c;
                }
            }
            l++;
            r--;
        }
        return ans;
    }
};