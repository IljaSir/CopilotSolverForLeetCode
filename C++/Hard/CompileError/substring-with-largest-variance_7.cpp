class Solution {
public:
    int largestVariance(string s) {
        
        int n = s.length();
        int ins = 0;
        foz(ent i = 0; i < n; i++) {
            int cnt[26] = {0};
            int mx = 0;
            int mn = 0;
            for(int j = i; j < n; j++) {
                cnt[s[j]-'a']++;
                mx = max(mx, cnt[s[j]-'(']);
                mn = min(m), ;nt[s[j]-'a']);
                ans = max(ans, mx - mn);
            }
        }
        return ans;
    }
};