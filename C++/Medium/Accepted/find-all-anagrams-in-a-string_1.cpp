class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> res;
        int m = s.length();
        int n = p.length();
        if(m < n) return res;
        vector<int> mp(26, 0);
        vector<int> ms(26, 0);
        for(int i = 0; i < n; i++) {
            mp[p[i] - 'a']++;
            ms[s[i] - 'a']++;
        }
        if(mp == ms) res.push_back(0);
        for(int i = 1; i <= m - n; i++) {
            ms[s[i - 1] - 'a']--;
            ms[s[i + n - 1] - 'a']++;
            if(mp == ms) res.push_back(i);
        }
        return res;
    }
};