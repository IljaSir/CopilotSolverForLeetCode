class Solution {
public:
    int minSteps(string s, string t) {
        
        int a[26] = {0};
        for (char c : s) {
            a[c - 'a']++;
        }
        for (char c : t) {
            a[c - 'a']--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += abs(a[i]);
        }
        return res / 2;
    }
};