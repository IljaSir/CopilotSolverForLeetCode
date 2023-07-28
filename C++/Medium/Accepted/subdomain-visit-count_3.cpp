class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        
        unordered_map<string, int> m;
        for (auto &s: cpdomains) {
            int i = s.find(' ');
            int n = stoi(s.substr(0, i));
            string domain = s.substr(i + 1);
            for (int i = 0; i < domain.size(); ++i) {
                if (domain[i] == '.') {
                    m[domain.substr(i + 1)] += n;
                }
            }
            m[domain] += n;
        }
        vector<string> res;
        for (auto &p: m) {
            res.push_back(to_string(p.second) + ' ' + p.first);
        }
        return res;
    }
};