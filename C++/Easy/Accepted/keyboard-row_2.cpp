class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        
        vector<string> result;
        string row1 = "qwertyuiop";
        string row2 = "asdfghjkl";
        string row3 = "zxcvbnm";
        for (auto word: words) {
            string lowerWord;
            for (auto c: word) {
                lowerWord.push_back(tolower(c));
            }
            if (row1.find(lowerWord[0]) != string::npos) {
                bool isFound = true;
                for (auto c: lowerWord) {
                    if (row1.find(c) == string::npos) {
                        isFound = false;
                        break;
                    }
                }
                if (isFound) {
                    result.push_back(word);
                }
            } else if (row2.find(lowerWord[0]) != string::npos) {
                bool isFound = true;
                for (auto c: lowerWord) {
                    if (row2.find(c) == string::npos) {
                        isFound = false;
                        break;
                    }
                }
                if (isFound) {
                    result.push_back(word);
                }
            } else if (row3.find(lowerWord[0]) != string::npos) {
                bool isFound = true;
                for (auto c: lowerWord) {
                    if (row3.find(c) == string::npos) {
                        isFound = false;
                        break;
                    }
                }
                if (isFound) {
                    result.push_back(word);
                }
            }
        }
        return result;
    }
};