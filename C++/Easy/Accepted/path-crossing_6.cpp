class Solution {
public:
    bool isPathCrossing(string path) {
        
        unordered_map<int, unordered_set<int>> m;
        int x = 0;
        int y = 0;
        m[x].insert(y);
        for (char c: path) {
            switch (c) {
                case 'N': ++y; break;
                case 'S': --y; break;
                case 'E': ++x; break;
                case 'W': --x; break;
            }
            if (m[x].find(y) != m[x].end()) {
                return true;
            }
            m[x].insert(y);
        }
        return false;
    }
};