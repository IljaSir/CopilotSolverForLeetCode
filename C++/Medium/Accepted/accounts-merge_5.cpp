class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        vector<vector<string>> res;
        unordered_map<string, string> emailName;
        unordered_map<string, string> parents;
        unordered_map<string, set<string>> unions;
        for (auto& account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parents[account[i]] = account[i];
                emailName[account[i]] = account[0];
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
            emails.insert(emails.begin(), emailName[it.first]);
            res.push_back(emails);
        }
        return res;
    }
    string find(string s, unordered_map<string, string>& parents) {
        return parents[s] == s ? s : find(parents[s], parents);
    }
};