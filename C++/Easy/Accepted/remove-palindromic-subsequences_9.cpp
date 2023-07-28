class Solution {
public:
    int removePalindromeSub(string s) {
        
        if (s.empty()) return 0;
        return s == string(s.rbegin(), s.rend()) ? 1 : 2; // if palindromic, remove all, else remove a and b
    }
};