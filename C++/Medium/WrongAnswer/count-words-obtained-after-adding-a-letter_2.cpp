class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        int count = 0;
        for (int i = 0; i < targetWords.size(); i++) {
            int j = 0;
            for (j = 0; j < startWords.size(); j++) {
                if (isPossible(startWords[j], targetWords[i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
    bool isPossible(string& startWord, string& targetWord) {
        if (targetWord.size() < startWord.size()) return false;
        if (targetWord.size() - startWord.size() > 26) return false;
        int targetCount[26] = {0};
        for (char targetChar: targetWord) {
            targetCount[targetChar - 'a']++;
        }
        for (char startChar: startWord) {
            targetCount[startChar - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (targetCount[i] < 0) return false;
        }
        return true;
    }
};