class Solution {
public:
    vector<int> groupStrings(vector<string>& words) {
        
        unordered_map<string, vector<string>> m;
        for (string w : words) {
            string key = "";
            for (char c : w) {
                key += to_string((c - w[0] + 26) % 26) + ",";
            }
            m[key].push_back(w);
        }
        int maxGroup = 0, maxSize = 0;
        for (auto p : m) {
            maxGroup++;
            maxSize = max(maxSize, (int)p.second.size());
        }
        return {maxGroup, maxSize};
    }
};