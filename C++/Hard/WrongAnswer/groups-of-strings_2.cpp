class Solution {
public:
    vector<int> groupStrings(vector<string>& words) {
        
        int n = words.size();
        unordered_map<string, int> map;
        for (int i = 0; i < n; i++) {
            string key = "";
            for (int j = 1; j < words[i].size(); j++) {
                int diff = words[i][j] - words[i][j - 1];
                if (diff < 0) diff += 26;
                key += diff;
                key += ',';
            }
            map[key]++;
        }
        int maxGroup = 0, maxSize = 0;
        for (auto it = map.begin(); it != map.end(); it++) {
            maxGroup++;
            maxSize = max(maxSize, it->second);
        }
        return {maxGroup, maxSize};
    }
};