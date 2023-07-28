class Solution {
public:
    bool possiblyEquals(string s1, string s2) {
        
        // cout << s1 << " | " << s2 << endl;
        if (s1.size() == 0 || s2.size() == 0) return false;
        if (s1.size() == 1 && s2.size() == 1) return s1[0] == s2[0];
        if (s1.size() == 1 && s2.size() > 1) return s1[0] == s2[1];
        if (s1.size() > 1 && s2.size() == 1) return s2[0] == s1[1];
        if (s1.size() == 2 && s2.size() == 2) return s1[0] == s2[0] && s1[1] == s2[1];
        if (s1.size() == 2 && s2.size() > 2) return s1[0] == s2[1] && s1[1] == s2[2];
        if (s1.size() > 2 && s2.size() == 2) return s2[0] == s1[1] && s2[1] == s1[2];
        if (s1.size() == 3 && s2.size() == 3) return s1[0] == s2[0] && s1[1] == s2[1] && s1[2] == s2[2];
        if (s1.size() == 3 && s2.size() > 3) return s1[0] == s2[1] && s1[1] == s2[2] && s1[2] == s2[3];
        if (s1.size() > 3 && s2.size() == 3) return s2[0] == s1[1] && s2[1] == s1[2] && s2[2] == s1[3];
        return false;
    }
};