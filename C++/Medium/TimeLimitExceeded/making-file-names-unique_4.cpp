class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        vector<string> res;
        unordered_map<string, int> m;
        for (string s : names) {
            if (m.find(s) == m.end()) {
                res.push_back(s);
                m[s]++;
            } else {
                int k = m[s];
                while (m.find(s + "(" + to_string(k) + ")") != m.end()) {
                    k++;
                }
                res.push_back(s + "(" + to_string(k) + ")");
                m[s + "(" + to_string(k) + ")"]++;
            }
        }
        return res;
    }
};