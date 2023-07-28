class Solution {
public:
    string capitalizeTitle(string title) {
        
        string result = "";
        bool isWordStart = true;
        for (char c : title) {
            if (isWordStart) {
                if (c >= 'a' && c <= 'z') {
                    result += c - 'a' + 'A';
                } else {
                    result += c;
                }
                isWordStart = false;
            } else {
                if (c == ' ') {
                    isWordStart = true;
                }
                result += c;
            }
        }
        return result;
    }
};