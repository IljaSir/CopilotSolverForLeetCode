class Solution {
public:
    string reverseWords(string s) {
        
        int start = 0;
        int end = 0;
        string result;
        while(end < s.length()) {
            if (s[end] == ' ') {
                for (int i = end - 1; i >= start; i--) {
                    result.push_back(s[i]);
                }
                result.push_back(' ');
                start = end + 1;
            }
            end++;
        }
        for (int i = end - 1; i >= start; i--) {
            result.push_back(s[i]);
        }
        return result;
    }
};