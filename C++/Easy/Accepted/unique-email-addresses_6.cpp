class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        
        unordered_set<string> s;
        for (string& email: emails) {
            string local, domain;
            bool plus = false;
            for (char c: email) {
                if (c == '@') {
                    domain = email.substr(email.find('@'));
                    break;
                }
                if (c == '+') {
                    plus = true;
                }
                if (c == '.' || plus) {
                    continue;
                }
                local += c;
            }
            s.insert(local + domain);
        }
        return s.size();
    }
};