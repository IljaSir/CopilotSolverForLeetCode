class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        map<string, string> emailToName;
        map<string, vector<string>> graph;
        for (auto account : accounts) {
            string name = account[0];
            for (int i = 1; i < account.size(); i++) {
                emailToName[account[i]] = name;
                graph[account[i]].push_back(account[1]);
                graph[account[1]].push_back(account[i]);
            }
        }
        set<string> visited;
        vector<vector<string>> result;
        for (auto email : emailToName) {
            if (visited.find(email.first) == visited.end()) {
                vector<string> emails;
                dfs(email.first, graph, visited, emails);
                sort(emails.begin(), emails.end());
                emails.insert(emails.begin(), email.second);
                result.push_back(emails);
            }
        }
        return result;
    }
    
    void dfs(string email, map<string, vector<string>> &graph, set<string> &visited, vector<string> &emails) {
        emails.push_back(email);
        visited.insert(email);
        for (auto next : graph[email]) {
            if (visited.find(next) == visited.end()) {
                dfs(next, graph, visited, emails);
            }
        }
    }
};