class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        unordered_map<string, int> m;
        vector<string> ans;
        for (auto &name : names) {
            if (m.find(name) == m.end()) {
                ans.push_back(name);
                m[name] = 1;
            } else {
                int k = m[name];
                while (m.find(name + "(" + to_string(k) + ")") != m.end()) {
                    ++k;
                }
                m[name + "(" + to_string(k) + ")"] = 1;
                ans.push_back(name + "(" + to_string(k) + ")");
                ++m[name];
            }
        }
        return ans;
    }
};