class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        
        unordered_set<string> us;
        for(auto& email: emails) {
            string local, domain;
            int i = 0;
            for(; email[i] != '@'; i++) {
                if(email[i] == '.') continue;
                if(email[i] == '+') break;
                local.push_back(email[i]);
            }
            for(; email[i] != '@'; i++) ;
            for(; i < email.size(); i++) {
                domain.push_back(email[i]);
            }
            us.insert(local + domain);
        }
        return us.size();
    }
};