class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        
        unordered_map<string, int> counts;
        for (string &cpdomain: cpdomains) {
            int i = cpdomain.find(' ');
            int n = stoi(cpdomain.substr(0, i));
            string &s = cpdomain.substr(i + 1);
            for (int i = 0; i < s.size(); ++i) {
                if (s[i] == '.') counts[s.substr(i + 1)] += n;
            }
            counts[s] += n;
        }

        vector<string> ans;
        for (auto &p: counts) {
            ans.push_back(to_string(p.second) + " " + p.first);
        }
        return ans;
    }
};