class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int len = s.length();
        int i = 0;
        int j = len - 1;
        int count = 0;
        while (i < j) {
            if (s[i] != s[j]) {
                count++;
                if (s[i] > s[j]) {
                    s[j] = s[i];
                } else {
                    s[i] = s[j];
                }
            }
            i++;
            j--;
        }
        return count;
    }
};