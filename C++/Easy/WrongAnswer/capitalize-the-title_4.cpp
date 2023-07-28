class Solution {
public:
    string capitalizeTitle(string title) {
        
        string result;
        bool isSpace = true;
        for (char c : title) {
            if (isSpace) {
                result += toupper(c);
            } else {
                result += tolower(c);
            }
            isSpace = c == ' ';
        }
        return result;
    }
};