class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        int n = startGene.size();
        unordered_map<string, vector<string>> graph;
        for (auto& s: bank) {
            for (int i = 0; i < n; ++i) {
                string key = s.substr(0, i) + "*" + s.substr(i+1);
                graph[key].push_back(s);
            }
        }
        queue<string> q;
        q.push(startGene);
        unordered_set<string> visited;
        visited.insert(startGene);
        int level = 0;
        while (!q.empty()) {
            ++level;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                string cur = q.front();
                q.pop();
                for (int j = 0; j < n; ++j) {
                    string key = cur.substr(0, j) + "*" + cur.substr(j+1);
                    for (auto& s: graph[key]) {
                        if (s == endGene) return level;
                        if (visited.find(s) == visited.end()) {
                            q.push(s);
                            visited.insert(s);
                        }
                    }
                }
            }
        }
        return -1;
    }
};