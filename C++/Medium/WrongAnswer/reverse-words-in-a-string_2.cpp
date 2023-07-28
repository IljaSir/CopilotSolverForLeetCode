class Solution {
public:
    string reverseWords(string s) {
        
        string result;
        int i = 0;
        while (i < s.size()) {
            while (i < s.size() && s[i] == ' ') {
                i++;
            }
            if (i == s.size()) {
                break;
            }
            if (result.size() > 0) {
                result.push_back(' ');
            }
            string word;
            while (i < s.size() && s[i] != ' ') {
                word.push_back(s[i++]);
            }
            result = word + " " + result;
        }
        return result;
    }
};