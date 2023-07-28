class Solution {
public:
    bool isScramble(string s1, string s2) {
        
        if (s1 == s2) return true;
        int n = s1.length();
        vector<int> cnt1(26), cnt2(26);
        for (int i = 0; i < n; i++) {
            cnt1[s1[i] - 'a']++;
            cnt2[s2[i] - 'a']++;
        }
        if (cnt1 != cnt2) return false;
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substr(0, i), s2.substr(0, i)) && isScramble(s1.substr(i), s2.substr(i))) return true;
            if (isScramble(s1.substr(0, i), s2.substr(n - i)) && isScramble(s1.substr(i), s2.substr(0, n - i))) return true;
        }
        return false;
    }
};