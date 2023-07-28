class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        int count = 0;
        for (int i = 0; i < targetWords.size(); i++) {
            bool found = false;
            for (int j = 0; j < startWords.size(); j++) {
                if (startWords[j].length() < targetWords[i].length()) {
                    continue;
                }
                int diff = 0;
                for (int k = 0; k < targetWords[i].length(); k++) {
                    if (startWords[j].find(targetWords[i][k]) == string::npos) {
                        diff++;
                    }
                }
                if (diff == targetWords[i].length() - startWords[j].length()) {
                    found = true;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }
        return count;
    }
};