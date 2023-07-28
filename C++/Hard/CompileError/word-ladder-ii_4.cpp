class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end()) return {};
        unordered_set<string> head{beginWord}, tail{endWord}, *phead = &head, *ptail = &tail;
        unordered_map<string, vector<string>> children;
        bool found = false, backward = false;
        while (!phead->empty() && !ptail->empty() && !found) {
            if (phead->size() > ptail->size()) {
                swap(phead, ptail);
                backward = !backward;
            }
            unordered_set<string> temp;
            for (const string &word : *phead) {
                dict.erase(word);
                for (int i = 0; i < word.size(); ++i) {
                    string new_word = word;
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        new_word[i] = ch;
                        if (ptail->find(new_word) != ptail->end()) {
                            found = true;
                            backward ? children[new_word].push_back(word) : children[word].push_back(new_word);
                        }
                        if (!found && dict.find(new_word) != dict.end()) {
                            temp.insert(new_word);
                            backward ? children[new_word].push_back(word) : children[word].push_back(new_word);
                        }
                    }
                }
            }
            swap(*phead, temp);
        }
        vector<vector<string>> res;
        if (found) {
            vector<string> out = {beginWord};
            gen_paths(beginWord, endWord, children, out, res);
        }
        return res;
    }
};