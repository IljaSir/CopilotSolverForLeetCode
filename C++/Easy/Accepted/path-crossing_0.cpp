class Solution {
public:
    bool isPathCrossing(string path) {
        
        int x = 0, y = 0;
        set<pair<int, int>> s;
        s.insert(make_pair(0, 0));
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
            if (s.find(make_pair(x, y)) != s.end()) {
                return true;
            }
            s.insert(make_pair(x, y));
        }
        return false;
    }
};