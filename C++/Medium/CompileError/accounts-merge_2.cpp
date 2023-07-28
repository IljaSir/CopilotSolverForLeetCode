class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        unordered_map<string, string> owner;
        unordered_map<string, string> parents;
        unordered_map<string, set<string>> unions;
        vector<vector<string>> res;
        for (auto& account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parents[account[i]] = account[i];
                owner[account[i]] = account[0];
            }
        }
        for (auto& account : accounts) {
            string p = find(account[1], parents);
            for (int i = 2; i < account.size(); i++) {
                parents[find(account[i], parents)] = p;
            }
        }
        for (auto& account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                unions[find(account[i], parents)].insert(account[i]);
            }
        }
        for (auto& a : unions) {
            vector<string> emails (a.second.begin(), a.second.end());
            emails.insert(emails.begin(), owner[a.first]);
            res.push_back(emails);
        }
        return res;
    }
};