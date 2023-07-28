class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end());
        vector<vector<string>> res;
        if (dict.find(endWord) == dict.end()) return res;
        unordered_map<string, vector<string>> next;
        unordered_set<string> cur{beginWord}, nextLevel;
        bool found = false;
        while (!cur.empty() && !found) {
            for (auto& s : cur) dict.erase(s);
            for (auto& s : cur) {
                string t = s;
                for (int i = 0; i < s.size(); ++i) {
                    char c = s[i];
                    for (int j = 0; j < 26; ++j) {
                        s[i] = 'a' + j;
                        if (dict.find(s) != dict.end()) {
                            if (s == endWord) found = true;
                            else nextLevel.insert(s);
                            next[t].push_back(s);
                        }
                    }
                    s[i] = c;
                }
            }
            swap(cur, nextLevel);
            nextLevel.clear();
        }
        if (found) {
            vector<string> path{beginWord};
            dfs(res, path, next, beginWord, endWord);
        }
        return res;
    }
    void dfs(vector<vector<string>>& res, vector<string>& path, unordered_map<string, vector<string>>& next, string& beginWord, string& endWord) {
        if (beginWord == endWord) {
            res.push_back(path);
            return;
        }
        for (auto& s : next[beginWord]) {
            path.push_back(s);
            dfs(res, path, next, s, endWord);
            path.pop_back();
        }
    }
};