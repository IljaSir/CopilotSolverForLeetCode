class Solution {
public:
    int countPoints(string rings) {
        
        unordered_map<char, set<int>> map;
        for (int i = 0; i < rings.size(); i += 2) {
            map[rings[i]].insert(rings[i + 1] - '0');
        }
        int res = 0;
        for (auto it = map.begin(); it != map.end(); ++it) {
            if (it->second.size() == 10) {
                ++res;
            }
        }
        return res;
    }
};