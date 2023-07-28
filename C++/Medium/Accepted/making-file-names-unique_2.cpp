class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        unordered_map<string, int> m;
        vector<string> ans;
        for (string name : names) {
            if (m.count(name) == 0) {
                m[name] = 1;
                ans.push_back(name);
            } else {
                int k = m[name];
                while (m.count(name + "(" + to_string(k) + ")") > 0) {
                    k++;
                }
                m[name + "(" + to_string(k) + ")"] = 1;
                ans.push_back(name + "(" + to_string(k) + ")");
                m[name] = k + 1;
            }
        }
        return ans;
    }
};