class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        std::unordered_set<string> word_set(wordList.begin(), wordList.end());
        if (word_set.find(endWord) == word_set.end()) {
            return 0;
        }
        std::unordered_set<string> begin_set;
        begin_set.insert(beginWord);
        std::unordered_set<string> end_set;
        end_set.insert(endWord);
        int n = beginWord.size();
        int step = 1;
        while (!begin_set.empty() && !end_set.empty()) {
            if (begin_set.size() > end_set.size()) {
                std::swap(begin_set, end_set);
            }
            std::unordered_set<string> temp_set;
            for (const string& word : begin_set) {
                for (int i = 0; i < n; ++i) {
                    string new_word = word;
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        new_word[i] = ch;
                        if (end_set.find(new_word) != end_set.end()) {
                            return step + 1;
                        }
                        if (word_set.find(new_word) != word_set.end()) {
                            temp_set.insert(new_word);
                            word_set.erase(new_word);
                        }
                    }
                }
            }
            ++step;
            std::swap(begin_set, temp_set);
        }
        return 0;
    }
};