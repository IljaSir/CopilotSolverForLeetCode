class Solution {
public:
    int removePalindromeSub(string s) {
        
        if (s.empty()) return 0;
        string t = s;
        reverse(t.begin(), t.end());
        return (s == t) ? 1 : 2;
    }
};