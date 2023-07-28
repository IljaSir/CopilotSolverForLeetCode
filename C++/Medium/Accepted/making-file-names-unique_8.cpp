class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        vector<string> res;
        unordered_map<string, int> m;
        for (auto& name: names) {
            if (m.count(name)) {
                int k = m[name];
                string s = name + "(" + to_string(k) + ")";
                while (m.count(s)) {
                    s = name + "(" + to_string(++k) + ")";
                }
                m[s] = 1;
                m[name] = k + 1;
                res.push_back(s);
            } else {
                m[name] = 1;
                res.push_back(name);
            }
        }
        return res;
    }
};