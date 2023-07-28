class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        
        unordered_map<string, int> counts;
        for (auto& cpdomain : cpdomains) {
            auto pos = cpdomain.find(' ');
            int count = stoi(cpdomain.substr(0, pos));
            string domain = cpdomain.substr(pos + 1);
            while (true) {
                counts[domain] += count;
                pos = domain.find('.');
                if (pos == string::npos) break;
                domain = domain.substr(pos + 1);
            }
        }

        vector<string> result;
        for (auto& [domain, count] : counts) {
            result.push_back(to_string(count) + " " + domain);
        }
        return result;
    }
};