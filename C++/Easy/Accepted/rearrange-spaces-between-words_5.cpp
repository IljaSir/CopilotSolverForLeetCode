class Solution {
public:
    string reorderSpaces(string text) {
        
        int spaceCount = 0;
        int wordCount = 0;
        for (auto ch : text) {
            if (ch == ' ') {
                spaceCount++;
            }
        }
        stringstream ss(text);
        string word;
        vector<string> words;
        while (ss >> word) {
            words.push_back(word);
        }
        wordCount = words.size();
        if (wordCount == 1) {
            string result = words[0];
            for (int i = 0; i < spaceCount; i++) {
                result += ' ';
            }
            return result;
        }
        int spacePerWord = spaceCount / (wordCount - 1);
        int extraSpace = spaceCount % (wordCount - 1);
        string result = "";
        for (int i = 0; i < words.size(); i++) {
            result += words[i];
            if (i != words.size() - 1) {
                for (int j = 0; j < spacePerWord; j++) {
                    result += ' ';
                }
            }
        }
        for (int i = 0; i < extraSpace; i++) {
            result += ' ';
        }
        return result;
    }
};