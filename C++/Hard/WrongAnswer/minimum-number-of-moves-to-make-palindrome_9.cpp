class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int n = s.size();
        int mid = n/2;
        int cnt = 0;
        for(int i=0; i<mid; i++){
            int j = n-i-1;
            if(s[i] == s[j]) continue;
            cnt++;
            if(s[i] > s[j]) swap(s[i], s[j]);
            if(s[i] == 'a' && s[j] == 'z') continue;
            if(s[i] == 'a') s[j]--;
            else s[i]--;
        }
        return cnt;
    }
};