class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end()) return {};
        vector<vector<string>> ans;
        unordered_map<string, vector<string>> next;
        unordered_map<string, int> dist;
        queue<string> q;
        q.push(beginWord);
        dist[beginWord] = 0;
        while (!q.empty()) {
            string cur = q.front();
            q.pop();
            int curDist = dist[cur];
            string nextWord = cur;
            for (int i = 0; i < cur.size(); ++i) {
                char origin = nextWord[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    nextWord[i] = c;
                    if (dict.find(nextWord) != dict.end()) {
                        if (dist.find(nextWord) == dist.end()) {
                            dist[nextWord] = curDist + 1;
                            q.push(nextWord);
                        }
                        if (dist[nextWord] == curDist + 1) {
                            next[cur].push_back(nextWord);
                        }
                    }
                }
                nextWord[i] = origin;
            }
        }
        vector<string> path = {beginWord};
        dfs(beginWord, endWord, next, path, ans);
        return ans;
    }
    void dfs(string& beginWord, string& endWord, unordered_map<string, vector<string>>& next, vector<string>& path, vector<vector<string>>& ans) {
        if (beginWord == endWord) {
            ans.push_back(path);
            return;
        }
        for (auto& word : next[beginWord]) {
            path.push_back(word);
            dfs(word, endWord, next, path, ans);
            path.pop_back();
        }
    }
};