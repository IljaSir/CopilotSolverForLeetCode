class Solution {
public:
    bool isIsomorphic(string s, string t) {
        
        int m[128] = {0}, n[128] = {0};
        for (int i = 0; i < s.length(); i++) {
            if (m[s[i]] != n[t[i]]) return false;
            m[s[i]] = i + 1;
            n[t[i]] = i + 1;
        }
        return true;
    }
};