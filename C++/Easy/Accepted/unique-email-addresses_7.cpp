class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        
        set<string> s;
        for(string& email: emails) {
            string local, domain;
            int at = email.find("@");
            local = email.substr(0, at);
            domain = email.substr(at);
            int plus = local.find("+");
            if (plus != string::npos)
                local = local.substr(0, plus);
            string tmp;
            for (char c: local)
                if (c != '.')
                    tmp.push_back(c);
            s.insert(tmp + domain);
        }
        return s.size();
    }
};