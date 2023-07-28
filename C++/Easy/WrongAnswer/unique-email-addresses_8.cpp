class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        
        unordered_set<string> uniqueEmails;
        for (auto& email : emails) {
            string localName;
            string domainName;
            bool localNameIsDone = false;
            for (auto& c : email) {
                if (c == '@') {
                    localNameIsDone = true;
                    continue;
                }
                if (localNameIsDone) {
                    domainName += c;
                } else if (c == '.') {
                    continue;
                } else if (c == '+') {
                    break;
                } else {
                    localName += c;
                }
            }
            uniqueEmails.insert(localName + "@" + domainName);
        }
        return uniqueEmails.size();
    }
};