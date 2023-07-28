class Solution {
public:
    string reorderSpaces(string text) {
        
        int i = 0;
        int spaceCount = 0;
        int wordCount = 0;
        string word = "";
        vector<string> words;
        for (i = 0; i < text.length(); i++) {
            if (text[i] == ' ') {
                spaceCount++;
                if (word != "") {
                    wordCount++;
                    words.push_back(word);
                    word = "";
                }
            } else {
                word += text[i];
            }
        }
        if (word != "") {
            wordCount++;
            words.push_back(word);
        }
        int spaceBetweenWords = 0;
        int spaceAtEnd = 0;
        if (wordCount > 1) {
            spaceBetweenWords = spaceCount / (wordCount - 1);
            spaceAtEnd = spaceCount % (wordCount - 1);
        } else {
            spaceAtEnd = spaceCount;
        }
        string result = "";
        for (i = 0; i < words.size(); i++) {
            result += words[i];
            if (i < words.size() - 1) {
                for (int j = 0; j < spaceBetweenWords; j++) {
                    result += " ";
                }
            }
        }
        for (i = 0; i < spaceAtEnd; i++) {
            result += " ";
        }
        return result;
    }
};