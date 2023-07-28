class Solution {
public:
    string longestPrefix(string s) {
        
        string result = "";
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (s[i] == s[j]) {
                result += s[i];
                i++;
                j--;
            } else {
                i = 0;
                result = "";
                j--;
            }
        }
        return result;
    }
};