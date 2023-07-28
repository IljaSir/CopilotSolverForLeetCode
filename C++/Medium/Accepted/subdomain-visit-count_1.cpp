class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        
        unordered_map<string, int> m;
        for (auto cp : cpdomains) {
            int i = cp.find(' ');
            int n = stoi(cp.substr(0, i));
            string s = cp.substr(i + 1);
            for (int i = 0; i < s.size(); ++i) {
                if (s[i] == '.') {
                    m[s.substr(i + 1)] += n;
                }
            }
            m[s] += n;
        }
        vector<string> res;
        for (auto a : m) {
            res.push_back(to_string(a.second) + " " + a.first);
        }
        return res;
    }
};