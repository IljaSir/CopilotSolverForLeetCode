class Solution {
public:
    bool isPalindrome(string s) {
        
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
            while (i < len && !isalnum(s[i])) i++;
            while (j >= 0 && !isalnum(s[j])) j--;
            if (i >= j) break;
            if (toupper(s[i]) != toupper(s[j])) return false;
            i++;
            j--;
        }
        return true;
    }
};