class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        
        unordered_map<string, int> count;
        for (auto cpdomain : cpdomains) {
            int space = cpdomain.find(' ');
            int n = stoi(cpdomain.substr(0, space));
            string s = cpdomain.substr(space + 1);
            for (int i = 0; i < s.size(); ++i) {
                if (s[i] == '.') {
                    count[s.substr(i + 1)] += n;
                }
            }
            count[s] += n;
        }
        vector<string> ans;
        for (auto& [s, n] : count) {
            ans.push_back(to_string(n) + ' ' + s);
        }
        return ans;
    }
};