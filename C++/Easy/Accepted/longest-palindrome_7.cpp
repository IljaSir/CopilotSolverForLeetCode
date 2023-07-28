class Solution {
public:
    int longestPalindrome(string s) {
        
        int n = s.length();
        int count[256] = {0};
        for(int i=0; i<n; i++) {
            count[s[i]]++;
        }
        int ans = 0;
        for(int i=0; i<256; i++) {
            ans += count[i]/2*2;
            if(ans%2==0 && count[i]%2==1) ans++;
        }
        return ans;
    }
};