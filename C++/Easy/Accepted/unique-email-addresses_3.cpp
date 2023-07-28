class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        
        set<string> uniqueEmails;
        for (string email : emails) {
            string local = email.substr(0, email.find('@'));
            string domain = email.substr(email.find('@'));
            local.erase(remove(local.begin(), local.end(), '.'), local.end());
            local = local.substr(0, local.find('+'));
            uniqueEmails.insert(local + domain);
        }
        return uniqueEmails.size();
    }
};