class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        unordered_map<string, int> email2id;
        unordered_map<int, string> id2name;
        vector<vector<int>> graph(accounts.size());
        int id = 0;
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts[i].size(); j++) {
                if (email2id.find(accounts[i][j]) == email2id.end()) {
                    email2id[accounts[i][j]] = id++;
                    id2name[email2id[accounts[i][j]]] = accounts[i][0];
                }
                graph[i].push_back(email2id[accounts[i][j]]);
            }
        }
        vector<bool> visited(id, false);
        vector<vector<string>> ans;
        for (int i = 0; i < accounts.size(); i++) {
            if (visited[graph[i][0]]) continue;
            vector<string> emails;
            dfs(graph, i, visited, emails);
            sort(emails.begin(), emails.end());
            emails.insert(emails.begin(), id2name[graph[i][0]]);
            ans.push_back(emails);
        }
        return ans;
    }
    void dfs(vector<vector<int>>& graph, int i, vector<bool>& visited, vector<string>& emails) {
        if (visited[graph[i][0]]) return;
        visited[graph[i][0]] = true;
        for (int j = 1; j < graph[i].size(); j++) {
            emails.push_back(to_string(graph[i][j]));
            for (int k = 0; k < graph.size(); k++) {
                if (k == i) continue;
                for (int l = 1; l < graph[k].size(); l++) {
                    if (graph[i][j] == graph[k][l]) {
                        dfs(graph, k, visited, emails);
                    }
                }
            }
        }
    }
};