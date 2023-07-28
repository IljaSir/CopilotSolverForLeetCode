class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        
        int n = s1.size();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (s1[i] != s2[i]) diff++;
        }
        if (diff > 2) return false;
        if (diff == 0) return true;
        sort(s1.begin(), s1.end());
        sort(s2.begin(), s2.end());
        return s1 == s2;
    }
};