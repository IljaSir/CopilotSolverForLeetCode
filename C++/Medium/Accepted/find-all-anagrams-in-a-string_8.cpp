class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> res;
        vector<int> pmap(26, 0);
        vector<int> smap(26, 0);
        int lenp = p.length();
        int lens = s.length();
        int i;
        for (i = 0; i < lenp; i++) {
            pmap[p[i] - 'a']++;
        }
        for (i = 0; i < lens; i++) {
            smap[s[i] - 'a']++;
            if (i >= lenp) {
                smap[s[i - lenp] - 'a']--;
            }
            if (smap == pmap) {
                res.push_back(i - lenp + 1);
            }
        }
        return res;
    }
};