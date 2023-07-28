class Solution {
public:
    int firstUniqChar(string s) {
        
        int n = s.size();
        if(n == 0) return -1;
        if(n == 1) return 0;
        int cnt[26] = {0};
        for(int i = 0; i < n; i++) cnt[s[i] - 'a']++;
        for(int i = 0; i < n; i++) if(cnt[s[i] - 'a'] == 1) return i;
        return -1;
    }
};