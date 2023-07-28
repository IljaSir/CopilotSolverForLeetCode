class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if (wordSet.find(endWord) == wordSet.end()) {
            return 0;
        }
        unordered_set<string> beginSet{beginWord};
        unordered_set<string> endSet{endWord};
        int len = 1;
        int strLen = beginWord.length();
        unordered_set<string> visited;
        while (!beginSet.empty() && !endSet.empty()) {
            if (beginSet.size() > endSet.size()) {
                swap(beginSet, endSet);
            }
            unordered_set<string> tempSet;
            for (string word : beginSet) {
                visited.insert(word);
                string newWord = word;
                for (int i = 0; i < strLen; i++) {
                    char originChar = newWord[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        newWord[i] = j;
                        if (endSet.find(newWord) != endSet.end()) {
                            return len + 1;
                        }
                        if (wordSet.find(newWord) != wordSet.end() && visited.find(newWord) == visited.end()) {
                            tempSet.insert(newWord);
                        }
                    }
                    newWord[i] = originChar;
                }
            }
            len++;
            swap(beginSet, tempSet);
        }
        return 0;
    }
};