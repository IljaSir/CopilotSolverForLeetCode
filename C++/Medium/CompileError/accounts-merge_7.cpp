class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        vector<vector<string>> result;
        unordered_map<string, int> emailToIndex;
        unordered_map<string, string> emailToName;
        int N = accounts.size();
        vector<int> parent(N, 0);
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < accounts[i].size(); j++) {
                if (emailToIndex.count(accounts[i][j]) == 0) {
                    emailToIndex[accounts[i][j]] = i;
                    emailToName[accounts[i][j]] = accounts[i][0];
                } else {
                    Union(i, emailToIndex[accounts[i][j]], parent);
                }
            }
        }
        unordered_map<int, set<string>> indexToEmails;
        for (int i = 0; i < N; i++) {
            int root = Find(i, parent);
            for (int j = 1; j < accounts[i].size(); j++) {
                indexToEmails[root].insert(accounts[i][j]);
            }
        }
        for (auto it = indexToEmails.begin(); it != indexToEmails.end(); it++) {
            vector<string> emails;
            emails.push_back(emailToName[*(it->second.begin())]);
            for (auto email : it->second) {
                emails.push_back(email);
            }
            result.push_back(emails);
        }
        return result;
    }
    int Find(int i, vector<int>& parent) {
        if (i != parent[i]) {
            parent[i] = Find(parent[i], parent);
        }
        return parent[i];
    }
};