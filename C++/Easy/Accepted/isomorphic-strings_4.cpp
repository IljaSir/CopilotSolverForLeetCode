class Solution {
public:
    bool isIsomorphic(string s, string t) {
        
        map<char, char> smap;
        map<char, char> tmap;
        for (int i = 0; i < s.length(); i++) {
            if (smap.find(s[i]) == smap.end()) {
                smap[s[i]] = t[i];
            } else {
                if (smap[s[i]] != t[i])
                    return false;
            }
            if (tmap.find(t[i]) == tmap.end()) {
                tmap[t[i]] = s[i];
            } else {
                if (tmap[t[i]] != s[i])
                    return false;
            }
        }
        return true;
    }
};