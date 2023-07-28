class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        
        unordered_set<string> seen;
        for (auto email : emails) {
            int i = email.find('@');
            string local = email.substr(0, i);
            string rest = email.substr(i);
            if (local.find('+') != string::npos)
                local = local.substr(0, local.find('+'));
            local.erase(remove(local.begin(), local.end(), '.'), local.end());
            seen.insert(local + rest);
        }
        return seen.size();
    }
};