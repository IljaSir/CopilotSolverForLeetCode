class Solution {
public:
    bool isPathCrossing(string path) {
        
        int x = 0;
        int y = 0;
        unordered_set<int> visited;
        visited.insert(0);
        for (auto c : path) {
            switch (c) {
                case 'N':
                    ++y;
                    break;
                case 'S':
                    --y;
                    break;
                case 'E':
                    ++x;
                    break;
                case 'W':
                    --x;
                    break;
            }
            auto key = (x << 16) + y;
            if (visited.find(key) != visited.end()) {
                return true;
            }
            visited.insert(key);
        }
        return false;
    }
};