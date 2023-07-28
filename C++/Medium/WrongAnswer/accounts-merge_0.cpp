class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        unordered_map<string, vector<int>> emailToIndex;
        for (int i = 0; i < accounts.size(); ++i) {
            for (int j = 1; j < accounts[i].size(); ++j) {
                emailToIndex[accounts[i][j]].push_back(i);
            }
        }
        vector<int> visited(accounts.size(), 0);
        vector<vector<string>> res;
        for (int i = 0; i < accounts.size(); ++i) {
            if (visited[i]) continue;
            visited[i] = 1;
            vector<string> emails;
            for (int j = 1; j < accounts[i].size(); ++j) {
                emails.push_back(accounts[i][j]);
            }
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int index = q.front(); q.pop();
                for (int j = 1; j < accounts[index].size(); ++j) {
                    string email = accounts[index][j];
                    for (auto k : emailToIndex[email]) {
                        if (visited[k]) continue;
                        visited[k] = 1;
                        q.push(k);
                        for (int l = 1; l < accounts[k].size(); ++l) {
                            emails.push_back(accounts[k][l]);
                        }
                    }
                }
            }
            sort(emails.begin(), emails.end());
            emails.insert(emails.begin(), accounts[i][0]);
            res.push_back(emails);
        }
        return res;
    }
};