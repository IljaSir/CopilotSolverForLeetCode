class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        vector<vector<string>> res;
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        unordered_map<string, vector<string>> graph;
        unordered_map<string, int> dist;
        if (!wordSet.count(endWord)) return res;
        bfs(beginWord, endWord, wordSet, graph, dist);
        vector<string> path{beginWord};
        dfs(beginWord, endWord, graph, dist, path, res);
        return res;
    }
    void bfs(string beginWord, string endWord, unordered_set<string>& wordSet, unordered_map<string, vector<string>>& graph, unordered_map<string, int>& dist) {
        queue<string> q;
        q.push(beginWord);
        dist[beginWord] = 0;
        while (!q.empty()) {
            string word = q.front(); q.pop();
            graph[word] = {};
            for (int i = 0; i < word.size(); ++i) {
                string newWord = word;
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    newWord[i] = ch;
                    if (wordSet.count(newWord) && newWord != word) {
                        graph[word].push_back(newWord);
                        if (!dist.count(newWord)) {
                            dist[newWord] = dist[word] + 1;
                            q.push(newWord);
                        }
                    }
                }
            }
        }
    }
    void dfs(string beginWord, string& endWord, unordered_map<string, vector<string>>& graph, unordered_map<string, int>& dist, vector<string>& path, vector<vector<string>>& res) {
        if (beginWord == endWord) {
            res.push_back(path);
            return;
        }
        for (auto& nextWord: graph[beginWord]) {
            if (dist[nextWord] == dist[beginWord] + 1) {
                path.push_back(nextWord);
                dfs(nextWord, endWord, graph, dist, path, res);
                path.pop_back();
            }
        }
    }
};