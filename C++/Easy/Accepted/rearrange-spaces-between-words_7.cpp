class Solution {
public:
    string reorderSpaces(string text) {
        
        int space_count = 0;
        int word_count = 0;
        string word;
        vector<string> words;
        for (char c: text) {
            if (c == ' ') {
                ++space_count;
                if (word.size() > 0) {
                    words.push_back(word);
                    word.clear();
                }
            } else {
                word += c;
            }
        }
        if (word.size() > 0) {
            words.push_back(word);
        }
        word_count = words.size();
        if (word_count == 1) {
            return words[0] + string(space_count, ' ');
        }
        int space_between_words = space_count / (word_count - 1);
        int extra_space = space_count % (word_count - 1);
        string res;
        for (int i = 0; i < word_count - 1; ++i) {
            res += words[i] + string(space_between_words, ' ');
        }
        res += words[word_count - 1] + string(extra_space, ' ');
        return res;
    }
};