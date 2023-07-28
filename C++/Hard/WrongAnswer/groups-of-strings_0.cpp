class Solution {
public:
    vector<int> groupStrings(vector<string>& words) {
        
        unordered_map<string, vector<string>> m;
        for (string word : words) {
            string key = "";
            for (char c : word) {
                key += to_string((c - word[0] + 26) % 26);
                key += ",";
            }
            m[key].push_back(word);
        }
        int maxGroup = 0, maxSize = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            maxGroup++;
            maxSize = max(maxSize, (int)it->second.size());
        }
        return {maxGroup, maxSize};
    }
};