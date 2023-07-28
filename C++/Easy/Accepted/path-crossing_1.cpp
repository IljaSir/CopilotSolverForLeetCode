class Solution {
public:
    bool isPathCrossing(string path) {
        
        int x = 0, y = 0;
        unordered_map<int, unordered_set<int>> m;
        m[0].insert(0);
        for (char c : path) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            if (m.find(x) != m.end() && m[x].find(y) != m[x].end()) {
                return true;
            } else {
                m[x].insert(y);
            }
        }
        return false;
    }
};