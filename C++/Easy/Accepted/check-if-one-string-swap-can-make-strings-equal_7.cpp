class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        
        int n = s1.size();
        int cnt = 0;
        int p1, p2;
        for (int i = 0; i < n; i++) {
            if (s1[i] != s2[i]) {
                cnt++;
                if (cnt == 1) {
                    p1 = i;
                } else if (cnt == 2) {
                    p2 = i;
                } else {
                    return false;
                }
            }
        }
        if (cnt == 0) {
            return true;
        } else if (cnt == 2) {
            return s1[p1] == s2[p2] && s1[p2] == s2[p1];
        } else {
            return false;
        }
    }
};