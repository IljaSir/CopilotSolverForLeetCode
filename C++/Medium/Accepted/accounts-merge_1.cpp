class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        unordered_map<string, string> emailToName;
        unordered_map<string, vector<string>> graph;
        for (auto account : accounts) {
            string name = account[0];
            for (int i = 1; i < account.size(); i++) {
                emailToName[account[i]] = name;
                graph[account[1]].push_back(account[i]);
                graph[account[i]].push_back(account[1]);
            }
        }
        vector<vector<string>> ans;
        unordered_set<string> seen;
        for (auto p : graph) {
            if (!seen.count(p.first)) {
                seen.insert(p.first);
                queue<string> q;
                q.push(p.first);
                vector<string> component;
                while (!q.empty()) {
                    string node = q.front();
                    q.pop();
                    component.push_back(node);
                    for (string neighbor : graph[node]) {
                        if (!seen.count(neighbor)) {
                            seen.insert(neighbor);
                            q.push(neighbor);
                        }
                    }
                }
                sort(component.begin(), component.end());
                component.insert(component.begin(), emailToName[p.first]);
                ans.push_back(component);
            }
        }
        return ans;
    }
};