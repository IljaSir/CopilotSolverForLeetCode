class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int i = 0, j = s.size() - 1;
        int ret = 0;
        while (i < j) {
            ret += abs(s[i] - s[j]);
            i++;
            j--;
        }
        return ret;
    }
};