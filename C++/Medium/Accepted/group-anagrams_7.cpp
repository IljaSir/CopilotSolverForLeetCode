class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        
        vector<vector<string>> res;
        unordered_map<string, vector<string>> m;
        for (auto& s: strs) {
            string t = s;
            sort(t.begin(), t.end());
            m[t].push_back(s);
        }
        for (auto& p: m) res.push_back(p.second);
        return res;
    }
};