class Solution {
public:
    bool isPathCrossing(string path) {
        
        unordered_map<int, int> map;
        int x = 0, y = 0;
        for (int i = 0; i < path.size(); i++) {
            if (path[i] == 'N') {
                y++;
            } else if (path[i] == 'S') {
                y--;
            } else if (path[i] == 'E') {
                x++;
            } else if (path[i] == 'W') {
                x--;
            }
            if (map[x] == y) {
                return true;
            }
            map[x] = y;
        }
        return false;
    }
};