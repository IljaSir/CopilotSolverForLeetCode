class Solution {
public:
    bool isIsomorphic(string s, string t) {
        
        int n = s.size();
        if (n != t.size()) return false;
        int m[256] = {0};
        int n[256] = {0};
        for (int i = 0; i < n; i++) {
            if (m[s[i]] != n[t[i]]) return false;
            m[s[i]] = i + 1;
            n[t[i]] = i + 1;
        }
        return true;
    }
};