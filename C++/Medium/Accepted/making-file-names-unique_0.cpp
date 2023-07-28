class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        unordered_map<string, int> m;
        vector<string> res;
        for (auto name : names) {
            if (m.find(name) == m.end()) {
                m[name] = 1;
                res.push_back(name);
            } else {
                int k = m[name];
                string new_name;
                while (true) {
                    new_name = name + "(" + to_string(k) + ")";
                    if (m.find(new_name) == m.end()) {
                        m[new_name] = 1;
                        m[name] = k + 1;
                        res.push_back(new_name);
                        break;
                    }
                    k++;
                }
            }
        }
        return res;
    }
};