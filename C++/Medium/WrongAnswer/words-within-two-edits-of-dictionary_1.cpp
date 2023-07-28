class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        
        unordered_set<string> dict;
        for (auto& word : dictionary) {
            dict.insert(word);
        }
        vector<string> result;
        for (auto& word : queries) {
            if (dict.count(word)) {
                result.push_back(word);
                continue;
            }
            for (int i = 0; i < word.size(); ++i) {
                char c = word[i];
                for (int j = 0; j < 26; ++j) {
                    word[i] = 'a' + j;
                    if (dict.count(word)) {
                        result.push_back(word);
                        break;
                    }
                }
                word[i] = c;
            }
        }
        return result;
    }
};