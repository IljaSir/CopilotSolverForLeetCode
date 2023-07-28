class Solution {
public:
    bool checkValidString(string s) {
        
        int n = s.size();
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(' || s[i] == '*') l++;
            else l--;
            if (l < 0) return false;
        }
        for (int i = n-1; i >= 0; i--) {
            if (s[i] == ')' || s[i] == '*') r++;
            else r--;
            if (r < 0) return false;
        }
        return true;
    }
};