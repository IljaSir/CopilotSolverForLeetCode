class Solution {
public:
    bool isIsomorphic(string s, string t) {
        
        int len = s.length();
        if (len != t.length()) return false;
        unordered_map<char, char> mp;
        unordered_set<char> st;
        for (int i = 0; i < len; ++i) {
            if (mp.find(s[i]) == mp.end()) {
                if (st.find(t[i]) != st.end()) return false;
                mp[s[i]] = t[i];
                st.insert(t[i]);
            } else {
                if (mp[s[i]] != t[i]) return false;
            }
        }
        return true;
    }
};