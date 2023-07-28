class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        
        unordered_set<string> s;
        for (string& email : emails) {
            string local = email.substr(0, email.find("@"));
            string domain = email.substr(email.find("@"));
            local = local.substr(0, local.find("+"));
            local.erase(remove(local.begin(), local.end(), '.'), local.end());
            s.insert(local + domain);
        }
        return s.size();
    }
};