class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        vector<string> res;
        unordered_map<string, int> m;
        for (auto& name : names) {
            if (m.find(name) == m.end()) {
                m[name] = 0;
            } else {
                int k = m[name];
                string newName = name + "(" + to_string(k) + ")";
                while (m.find(newName) != m.end()) {
                    k++;
                    newName = name + "(" + to_string(k) + ")";
                }
                m[name] = k + 1;
                m[newName] = 0;
                name = newName;
            }
            res.push_back(name);
        }
        return res;
    }
};