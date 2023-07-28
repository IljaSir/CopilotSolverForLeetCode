class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        unordered_map<string, int> m;
        vector<string> ans;
        for (auto &name : names) {
            if (m.find(name) == m.end()) {
                m[name] = 1;
                ans.push_back(name);
            } else {
                int i = m[name];
                string tmp = name + "(" + to_string(i) + ")";
                while (m.find(tmp) != m.end()) {
                    tmp = name + "(" + to_string(++i) + ")";
                }
                m[name] = i+1;
                m[tmp] = 1;
                ans.push_back(tmp);
            }
        }
        return ans;
    }
};