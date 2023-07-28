class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        
        unordered_map<string, string> emailToName;
        unordered_map<string, int> emailToParent;
        unordered_map<string, set<string>> parentToEmails;
        vector<vector<string>> ans;
        for (auto& account : accounts) {
            string name = account[0];
            for (int i = 1; i < account.size(); ++i) {
                string email = account[i];
                if (!emailToName.count(email)) {
                    emailToName[email] = name;
                }
                if (!emailToParent.count(email)) {
                    emailToParent[email] = email;
                }
                unionFind(email, account[1], emailToParent);
            }
        }
        for (auto& account : accounts) {
            string parent = find(account[1], emailToParent);
            for (int i = 1; i < account.size(); ++i) {
                string email = account[i];
                parentToEmails[parent].insert(email);
            }
        }
        for (auto& p : parentToEmails) {
            vector<string> emails(p.second.begin(), p.second.end());
            emails.insert(emails.begin(), emailToName[p.first]);
            ans.push_back(emails);
        }
        return ans;
    }

    string find(string email, unordered_map<string, int>& emailToParent) {
        while (email != emailToParent[email]) {
            email = emailToParent[email];
        }
        return email;
    }

    void unionFind(string email1, string email2, unordered_map<string, int>& emailToParent) {
        emailToParent[find(email1, emailToParent)] = find(email2, emailToParent);
    }
};