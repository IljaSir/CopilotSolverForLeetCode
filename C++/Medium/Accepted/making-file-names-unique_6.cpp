class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        vector<string> ans;
        unordered_map<string, int> m;
        for (auto n : names) {
            if (m.find(n) == m.end()) {
                ans.push_back(n);
                m[n] = 1;
            } else {
                int k = m[n];
                string newn = n + "(" + to_string(k) + ")";
                while (m.find(newn) != m.end()) {
                    ++k;
                    newn = n + "(" + to_string(k) + ")";
                }
                ans.push_back(newn);
                m[n] = k + 1;
                m[newn] = 1;
            }
        }
        return ans;
    }
};