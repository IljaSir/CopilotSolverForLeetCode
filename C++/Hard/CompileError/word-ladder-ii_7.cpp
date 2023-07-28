class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        vector<vector<string>> result;
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if (wordSet.find(endWord) == wordSet.end()) return result;
        unordered_set<string> q1, q2;
        q1.insert(beginWord);
        q2.insert(endWord);
        unordered_map<string, vector<string>> map;
        bool found = false;
        bool backward = false;
        while (!q1.empty() && !q2.empty()) {
            if (q1.size() > q2.size()) {
                swap(q1, q2);
                backward = !backward;
            }
            unordered_set<string> q;
            for (auto word : q1) {
                wordSet.erase(word);
            }
            for (auto word : q1) {
                for (int i = 0; i < word.size(); i++) {
                    char ch = word[i];
                    for (int j = 0; j < 26; j++) {
                        word[i] = 'a' + j;
                        if (q2.find(word) != q2.end()) {
                            found = true;
                            backward ? map[word].push_back(ch) : map[ch].push_back(word);
                        } else if (!found && wordSet.find(word) != wordSet.end()) {
                            q.insert(word);
                            backward ? map[word].push_back(ch) : map[ch].push_back(word);
                        }
                    }
                    word[i] = ch;
                }
            }
            if (found) break;
            swap(q, q1);
        }
        vector<string> path = {beginWord};
        dfs(beginWord, endWord, map, path, result);
        return result;
    }
    
    void dfs(string& beginWord, string& endWord, unordered_map<string, vector<string>>& map, vector<string>& path, vector<vector<string>>& result) {
        if (beginWord == endWord) {
            result.push_back(path);
            return;
        }
        for (auto ch : map[beginWord]) {
            path.push_back(ch);
            dfs(ch, endWord, map, path, result);
            path.pop_back();
        }
    }
};