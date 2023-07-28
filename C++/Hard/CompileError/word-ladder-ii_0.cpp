class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end()) {
            return {};
        }
        dict.erase(beginWord);
        dict.erase(endWord);
        unordered_map<string, vector<string>> adj;
        unordered_map<string, int> dist;
        vector<vector<string>> res;
        bfs(beginWord, endWord, dict, adj, dist);
        vector<string> path = {beginWord};
        dfs(beginWord, endWord, adj, dist, path, res);
        return res;
    }
    
    void bfs(const string& beginWord, const string& endWord, unordered_set<string>& dict, unordered_map<string, vector<string>>& adj, unordered_map<string, int>& dist) {
        queue<string> q;
        q.push(beginWord);
        dist[beginWord] = 0;
        while (!q.empty()) {
            string word = q.front();
            q.pop();
            vector<string> neighbors = getNeighbors(word, dict);
            for (auto& neighbor : neighbors) {
                adj[word].push_back(neighbor);
                if (dist.find(neighbor) == dist.end()) {
                    dist[neighbor] = dist[word] + 1;
                    q.push(neighbor);
                }
            }
        }
    }
    
    void dfs(const string& beginWord, const string& endWord, unordered_map<string, vector<string>>& adj, unordered_map<string, int>& dist, vector<string>& path, vector<vector<string>>& res) {
        if (beginWord == endWord) {
            res.push_back(path);
            return;
        }
        for (auto& neighbor : adj[beginWord]) {
            if (dist[neighbor] == dist[beginWord] + 1) {
                path.push_back(neighbor);
                dfs(neighbor, endWord, adj, dist, path, res);
                path.pop_back();
            }
        }
    }
};