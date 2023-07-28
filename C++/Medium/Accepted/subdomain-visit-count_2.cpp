class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        
        unordered_map<string, int> m;
        for (auto cpdomain : cpdomains) {
            int idx = cpdomain.find(' ');
            int count = stoi(cpdomain.substr(0, idx));
            string domain = cpdomain.substr(idx + 1);
            for (int i = 0; i < domain.size(); ++i) {
                if (domain[i] == '.') {
                    m[domain.substr(i + 1)] += count;
                }
            }
            m[domain] += count;
        }
        vector<string> res;
        for (auto it = m.begin(); it != m.end(); ++it) {
            res.push_back(to_string(it->second) + " " + it->first);
        }
        return res;
    }
};