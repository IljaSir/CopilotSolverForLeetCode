class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        unordered_set<string> startWordsSet(startWords.begin(), startWords.end());
        unordered_set<string> targetWordsSet(targetWords.begin(), targetWords.end());
        unordered_set<string> visited;
        int count = 0;
        for (auto& word : targetWordsSet) {
            if (startWordsSet.find(word) != startWordsSet.end()) {
                count++;
                continue;
            }
            if (visited.find(word) != visited.end()) {
                continue;
            }
            if (isPossible(startWordsSet, word, visited)) {
                count++;
            }
        }
        return count;
    }
    
    bool isPossible(unordered_set<string>& startWordsSet, string word, unordered_set<string>& visited) {
        if (startWordsSet.find(word) != startWordsSet.end()) {
            return true;
        }
        visited.insert(word);
        for (int i = 0; i < word.size(); i++) {
            string nextWord = word.substr(0, i) + word.substr(i + 1);
            if (visited.find(nextWord) == visited.end() && isPossible(startWordsSet, nextWord, visited)) {
                return true;
            }
        }
        return false;
    }
};