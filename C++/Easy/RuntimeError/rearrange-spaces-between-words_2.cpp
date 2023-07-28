class Solution {
public:
    string reorderSpaces(string text) {
        
        int n = text.size();
        int spaceCount = 0;
        int wordCount = 0;
        for (int i = 0; i < n; i++) {
            if (text[i] == ' ') {
                spaceCount++;
            }
        }
        string word;
        stringstream ss(text);
        vector<string> words;
        while (ss >> word) {
            words.push_back(word);
        }
        wordCount = words.size();
        int space = 0;
        if (wordCount > 1) {
            space = spaceCount / (wordCount - 1);
        }
        string result;
        for (int i = 0; i < words.size(); i++) {
            result += words[i];
            if (i < words.size() - 1) {
                for (int j = 0; j < space; j++) {
                    result += " ";
                }
            }
        }
        for (int i = 0; i < spaceCount % (wordCount - 1); i++) {
            result += " ";
        }
        return result;
    }
};