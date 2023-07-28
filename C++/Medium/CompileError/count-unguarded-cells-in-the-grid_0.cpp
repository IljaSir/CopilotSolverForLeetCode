class Solution {
public:
    int countUnguarded(int m, int n, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        
        set<pair<int, int>> guardSet;
        for (auto guard : guards) {
            guardSet.insert(make_pair(guard[0], guard[1]));
        }
        set<pair<int, int>> wallSet;
        for (auto wall : walls) {
            wallSet.insert(make_pair(wall[0], wall[1]));
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (guardSet.find(make_pair(i, j)) == guardSet.end()) {
                    // this cell is not guarded, check if it is visible
                    bool visible = false;
                    for (int x = i - 1; x >= 0; x--) {
                        if (wallSet.find(make_pair(x, j)) != wallSet.end()) {
                            break;
                        }
                        if (guardSet.find(make_pair(x, j)) != guardSet.end()) {
                            visible = true;
                            break;
                        }
                    }
                    if (visible) {
                        count++;
                        continue;
                    }
                    for (int x = i + 1; x < m; x++) {
                        if (wallSet.find(make_pair(x, j)) != wallSet.end()) {
                            break;
                        }
                        if (guardSet.find(make_pair(x, j)) != guardSet.end()) {
                            visible = true;
                            break;
                        }
                    }
                    if (visible) {
                        count++;
                        continue;
                    }
                    for (int y = j - 1; y >= 0; y--) {
                        if (wallSet.find(make_pair(i, y)) != wallSet.end()) {
                            break;
                        }
                        if (guardSet.find(make_pair(i, y)) != guardSet.end()) {
                            visible = true;
                            break;
                        }
                    }
                    if (visible) {
                        count++;
                        continue;
                    }
                    for (int y = j + 1; y < n; y++) {
                        if (wallSet.find(make_pair(i, y)) != wallSet.end()) {
                            break;
                        }
                        if (guardSet.find(make_pair(i, y)) != guardSet.end()) {
                            visible = true;
                            break;
                        }
                    }
                    if (visible) {
                        count++;
                        continue;
                    }
                }
            }
        }
        return
    }
};