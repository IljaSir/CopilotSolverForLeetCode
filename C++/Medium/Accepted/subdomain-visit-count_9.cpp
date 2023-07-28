class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        
        unordered_map<string, int> domain;
        for (auto& cpdomain : cpdomains) {
            int space = cpdomain.find(' ');
            int count = stoi(cpdomain.substr(0, space));
            string subdomain = cpdomain.substr(space + 1);
            while (!subdomain.empty()) {
                domain[subdomain] += count;
                int dot = subdomain.find('.');
                if (dot == string::npos) break;
                subdomain = subdomain.substr(dot + 1);
            }
        }
        vector<string> result;
        for (auto& pair : domain) {
            result.push_back(to_string(pair.second) + " " + pair.first);
        }
        return result;
    }
};