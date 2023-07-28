class Solution {
public:
    int containVirus(vector<vector<int>>& isInfected) {
        
        int m = isInfected.size(), n = isInfected[0].size();
        int ans = 0;
        while (true) {
            vector<vector<int>> walls(m, vector<int>(n));
            vector<vector<int>> areas;
            vector<vector<int>> fronts;
            vector<int> perimeters;
            int area = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1) {
                        isInfected[i][j] = 2;
                        vector<int> front = {i, j};
                        fronts.push_back(front);
                        int perimeter = 0;
                        while (!front.empty()) {
                            vector<int> next;
                            for (auto& f : front) {
                                int x = f / n, y = f % n;
                                for (int k = 0; k < 4; ++k) {
                                    int nx = x + dx[k], ny = y + dy[k];
                                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                        if (isInfected[nx][ny] == 0) {
                                            ++perimeter;
                                            isInfected[nx][ny] = -1;
                                        }
                                        else if (isInfected[nx][ny] == 1) {
                                            isInfected[nx][ny] = 2;
                                            next.push_back(nx * n + ny);
                                        }
                                    }
                                }
                            }
                            swap(front, next);
                        }
                        areas.push_back(front);
                        perimeters.push_back(perimeter);
                        area += front.size();
                    }
                }
            }
            if (area == 0) {
                break;
            }
            int best = 0;
            for (int i = 1; i < areas.size(); ++i) {
                if (perimeters[i] > perimeters[best]) {
                    best = i;
                }
            }
            ans += perimeters[best];
            for (int i = 0; i < areas.size(); ++i) {
                if (i != best) {
                    ans += areas[i].size();
                }
                else {
                    for (auto& idx : areas[i]) {
                        int x = idx / n, y =
    }
};