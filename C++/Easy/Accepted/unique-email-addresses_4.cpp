class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        
        unordered_set<string> s;
        for (auto email : emails) {
            string str;
            int i = 0;
            while (email[i] != '@') {
                if (email[i] == '.') {
                    i++;
                }
                else if (email[i] == '+') {
                    while (email[i] != '@') i++;
                }
                else {
                    str.push_back(email[i++]);
                }
            }
            while (i < email.size()) {
                str.push_back(email[i++]);
            }
            s.insert(str);
        }
        return s.size();
    }
};