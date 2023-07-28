class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if (wordSet.find(endWord) == wordSet.end()) {
            return 0;
        }
        unordered_set<string> beginSet{beginWord};
        unordered_set<string> endSet{endWord};
        int length = 1;
        int strLen = beginWord.length();
        while (!beginSet.empty() && !endSet.empty()) {
            if (beginSet.size() > endSet.size()) {
                swap(beginSet, endSet);
            }
            unordered_set<string> tempSet;
            for (string word : beginSet) {
                wordSet.erase(word);
                for (int i = 0; i < strLen; ++i) {
                    char ch = word[i];
                    for (int j = 'a'; j <= 'z'; ++j) {
                        word[i] = j;
                        if (endSet.find(word) != endSet.end()) {
                            return length + 1;
                        }
                        if (wordSet.find(word) != wordSet.end()) {
                            tempSet.insert(word);
                            wordSet.erase(word);
                        }
                    }
                    word[i] = ch;
                }
            }
            swap(beginSet, tempSet);
            ++length;
        }
        return 0;
    }
};