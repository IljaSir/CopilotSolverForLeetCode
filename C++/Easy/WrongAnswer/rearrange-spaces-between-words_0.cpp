class Solution {
public:
    string reorderSpaces(string text) {
        
        int spaces = 0;
        int words = 0;
        for (int i = 0; i < text.size(); i++) {
            if (text[i] == ' ') {
                spaces++;
            } else {
                words++;
                while (i < text.size() && text[i] != ' ') {
                    i++;
                }
            }
        }
        int space = words == 1 ? spaces : spaces / (words - 1);
        int extra = words == 1 ? 0 : spaces % (words - 1);
        string result = "";
        for (int i = 0; i < text.size(); i++) {
            if (text[i] == ' ') {
                continue;
            } else {
                if (result.size() > 0) {
                    for (int j = 0; j < space; j++) {
                        result += ' ';
                    }
                }
                while (i < text.size() && text[i] != ' ') {
                    result += text[i];
                    i++;
                }
            }
        }
        for (int i = 0; i < extra; i++) {
            result += ' ';
        }
        return result;
    }
};