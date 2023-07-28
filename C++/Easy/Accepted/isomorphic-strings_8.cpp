class Solution {
public:
    bool isIsomorphic(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        if (n != m) return false;
        vector<int> hash1(256, -1);
        vector<int> hash2(256, -1);
        for (int i = 0; i < n; i++) {
            if (hash1[s[i]] != hash2[t[i]]) return false;
            hash1[s[i]] = i;
            hash2[t[i]] = i;
        }
        return true;
    }
};