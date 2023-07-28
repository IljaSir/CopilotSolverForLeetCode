class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        
        unordered_map<int, int> m;
        for (auto& e : edges) {
            m[e[0]]++;
            m[e[1]]++;
        }
        for (auto& e : m) {
            if (e.second == edges.size()) return e.first;
        }
        return 0;
    }
};