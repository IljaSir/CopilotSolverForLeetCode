class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end())
            return {};
        vector<vector<string>> res;
        unordered_map<string, vector<string>> parents;
        unordered_set<string> q1{beginWord}, q2{endWord};
        bool found = false;
        while (!q1.empty() && !q2.empty() && !found) {
            if (q1.size() > q2.size())
                swap(q1, q2);
            unordered_set<string> q;
            for (auto word : q1) {
                dict.erase(word);
            }
            for (auto word : q1) {
                string w = word;
                for (int i = 0; i < w.size(); i++) {
                    char ch = w[i];
                    for (int j = 0; j < 26; j++) {
                        w[i] = 'a' + j;
                        if (q2.find(w) != q2.end()) {
                            found = true;
                            parents[w].push_back(word);
                        }
                        else if (!found && dict.find(w) != dict.end()) {
                            q.insert(w);
                            parents[w].push_back(word);
                        }
                    }
                    w[i] = ch;
                }
            }
            swap(q, q1);
        }
        if (found) {
            vector<string> path = {endWord};
            dfs(endWord, beginWord, parents, path, res);
        }
        return res;
    }
    void dfs(string& word, string& beginWord, unordered_map<string, vector<string>>& parents, vector<string>& path, vector<vector<string>>& res) {
        if (word == beginWord) {
            res.push_back(vector<string>(path.rbegin(), path.rend()));
            return;
        }
        for (auto p : parents[word]) {
            path.push_back(p);
            dfs(p, beginWord, parents, path, res);
            path.pop_back();
        }
    }
};