class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        
        int count = 0;
        int diff[2];
        for (int i = 0; i < s1.length(); i++) {
            if (s1[i] != s2[i]) {
                diff[count++] = i;
                if (count > 2) return false;
            }
        }
        return count == 0 || (count == 2 && s1[diff[0]] == s2[diff[1]] && s1[diff[1]] == s2[diff[0]]);
    }
};