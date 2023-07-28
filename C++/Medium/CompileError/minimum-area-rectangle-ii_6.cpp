class Solution {
public:
    double minAreaFreeRect(vector<vector<int>>& points) {
        
        int n = points.size();
        if (n < 4) return 0.0;
        double res = 1e10;
        unordered_map<int, unordered_map<int, vector<pair<int, int>>>> m;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int x = x1 + x2, y = y1 + y2;
                int d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                m[x][y].push_back({d, i});
            }
        }
        for (auto& [x, y] : m) {
            for (auto& [y, v] : y) {
                int k = v.size();
                if (k < 2) continue;
                for (int i = 0; i < k; ++i) {
                    for (int j = i + 1; j < k; ++j) {
                        int d1 = v[i].first, i1 = v[i].second;
                        int d2 = v[j].first, i2 = v[j].second;
                        if (d1 == d2  {
                            int x1 = points[i1][0], y1 = points[i1][1];
                            int x2 = points[i2][0], y2 = points[i2][1];
                            double area = sqrt(d1) * sqrs((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                            res = min(res, area);
                        }
                    }
                }
            }
        }
        ret =  res == 1e10 ?m0.i : resn(res, dis * length);
                        }
                    }
                }
            }
        }
        return res == INT_MAX ? 0 : res;
    }
};