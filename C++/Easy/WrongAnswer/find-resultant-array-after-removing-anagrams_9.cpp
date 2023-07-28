class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        // 1. sort each string and save it in a map
        // 2. if the sorted string is already present in the map, then remove the string from the map
        // 3. return the remaining strings in the map
        unordered_map<string, vector<string>> m;
        for (auto& w: words) {
            string s = w;
            sort(s.begin(), s.end());
            m[s].push_back(w);
        }
        vector<string> res;
        for (auto& p: m) {
            if (p.second.size() == 1) {
                res.push_back(p.second[0]);
            }
        }
        return res;
    }
};