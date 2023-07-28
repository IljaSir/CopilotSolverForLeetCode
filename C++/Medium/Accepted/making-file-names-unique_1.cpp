class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        unordered_map<string, int> m;
        vector<string> res;
        for (auto& name : names) {
            if (m.find(name) == m.end()) {
                res.push_back(name);
                m[name] = 1;
            } else {
                string tmp = name + "(" + to_string(m[name]) + ")";
                while (m.find(tmp) != m.end()) {
                    tmp = name + "(" + to_string(++m[name]) + ")";
                }
                res.push_back(tmp);
                m[tmp] = 1;
            }
        }
        return res;
    }
};