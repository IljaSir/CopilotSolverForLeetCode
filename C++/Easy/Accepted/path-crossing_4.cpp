class Solution {
public:
    bool isPathCrossing(string path) {
        
        set<pair<int, int>> s;
        int x = 0, y = 0;
        s.insert(make_pair(x, y));
        for (auto c: path) {
            switch (c) {
                case 'N': ++y; break;
                case 'S': --y; break;
                case 'E': ++x; break;
                case 'W': --x; break;
            }
            if (s.find(make_pair(x, y)) != s.end()) return true;
            s.insert(make_pair(x, y));
        }
        return false;
    }
};