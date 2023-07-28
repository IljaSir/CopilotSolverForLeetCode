class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if (wordSet.find(endWord) == wordSet.end()) return 0;
        unordered_set<string> beginSet{beginWord};
        unordered_set<string> endSet{endWord};
        int level = 1;
        while (!beginSet.empty() && !endSet.empty()) {
            if (beginSet.size() > endSet.size()) {
                swap(beginSet, endSet);
            }
            unordered_set<string> nextSet;
            for (auto word : beginSet) {
                wordSet.erase(word);
            }
            for (auto word : beginSet) {
                for (int i = 0; i < word.size(); i++) {
                    char ch = word[i];
                    for (int j = 0; j < 26; j++) {
                        word[i] = 'a' + j;
                        if (endSet.find(word) != endSet.end()) {
                            return level + 1;
                        }
                        if (wordSet.find(word) != wordSet.end()) {
                            nextSet.insert(word);
                            wordSet.erase(word);
                        }
                    }
                    word[i] = ch;
                }
            }
            swap(beginSet, nextSet);
            level++;
        }
        return 0;
    }
};