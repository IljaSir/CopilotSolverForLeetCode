class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        
        set<string> uniqueEmails;
        for (auto email : emails) {
            string localName;
            string domainName;
            int atIndex = email.find('@');
            localName = email.substr(0, atIndex);
            domainName = email.substr(atIndex);
            int plusIndex = localName.find('+');
            if (plusIndex != string::npos) {
                localName = localName.substr(0, plusIndex);
            }
            localName.erase(remove(localName.begin(), localName.end(), '.'), localName.end());
            uniqueEmails.insert(localName + domainName);
        }
        return uniqueEmails.size();
    }
};