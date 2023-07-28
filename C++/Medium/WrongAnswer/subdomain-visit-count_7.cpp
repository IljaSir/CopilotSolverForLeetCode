class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        
        vector<string> result;
        unordered_map<string, int> count;
        for (auto cpdomain : cpdomains) {
            int space = cpdomain.find(' ');
            int num = stoi(cpdomain.substr(0, space));
            for (int i = space + 1; i < cpdomain.size(); i++) {
                if (cpdomain[i] == '.' || i == cpdomain.size() - 1) {
                    count[cpdomain.substr(i + 1)] += num;
                }
            }
        }
        for (auto it = count.begin(); it != count.end(); it++) {
            result.push_back(to_string(it->second) + " " + it->first);
        }
        return result;
    }
};