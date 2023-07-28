class Solution {
public:
    int largestVariance(string s) {
        
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int cnt[26] = {0};
            int mx = 0;
            int mn = 0;
            for(int j = i; j < n; j++) {
                cnt[s[j]-'a']++;
                mx = max(mx, cnt[s[j]-'a']);
                mn = min(mn, cnt[s[j]-'a']);
                ans = max(ans, mx - mn);
            }
        }
        return ans;
    }
};