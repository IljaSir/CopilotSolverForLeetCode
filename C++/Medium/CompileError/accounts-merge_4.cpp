class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        map<string, string> owner;
        map<string, string> parents;
        map<string, set<string>> unions;
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
        for (auto& it : unions) {
            vector<string> emails(it.second.begin(), it.second.end());
            emails.insert(emails.begin(), owner[it.first]);
            res.push_back(emails);
        }
        return res;
    }
};