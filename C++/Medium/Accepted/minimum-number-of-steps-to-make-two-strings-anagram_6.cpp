class Solution {
public:
    int minSteps(string s, string t) {
        
        int a[26] = {0};
        int b[26] = {0};
        int n = s.size();
        for(int i = 0; i < n; i++) {
            a[s[i] - 'a']++;
            b[t[i] - 'a']++;
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            if(a[i] < b[i]) {
                ans += b[i] - a[i];
            }
        }
        return ans;
    }
};