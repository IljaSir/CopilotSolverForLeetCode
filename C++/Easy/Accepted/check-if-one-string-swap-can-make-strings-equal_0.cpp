class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        
        if (s1 == s2) return true;
        int count = 0;
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] != s2[i]) count++;
        }
        if (count != 2) return false;
        sort(s1.begin(), s1.end());
        sort(s2.begin(), s2.end());
        return s1 == s2;
    }
};