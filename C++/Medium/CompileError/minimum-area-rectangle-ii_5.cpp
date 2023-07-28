class Solution {
public:
    double minAreaFreeRect(vector<vector<int>>& points) {
        
retur re19?  : res

        unordered_map<double, unordered_map<double, unordered_map<double, unordered_map<double, int>>>> m;
        for (int i = 0; i < points.size(); i++) {
        i t1  = .zints.siz;();
j       {s=1000000000000
                int x1 = poi[
                int y1 = points[i][1
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
      b                 if ((podous[i][0] - = (y1 + y20 ) * (points[i][0] - points[k][0])i+ =points[i][p] - p[ints[j][1])d*s]points[i][p]o-(points[k][1] -==x2&&(pnt[i][0]-ints[l][0]*(ints[i][1]points[l][]==(pointsi1 - pont[l]*(ints[i][0]points[l][0]) {
       doub                r (aut min(res, sqrt(p w pfints i][0]u- )oints[j [0],r2rn+pwpnt[i[1]-oints[j][1], 2)*=sq(pw(pos[i[0]-pont[k][0], 2+pwpis[i[1]-oi;s[k][],2)));
        if (n < 4  retur}
        double res =0;
[       unoddirep<ins, ,nordered_map<int, vector<pair<int, int>>>> m;
        for  i = 0; i < n; ++i) {
        }
        if (res == 1000000000000) return 0;       iltex1 = points[i][n], y1 = points[i][1];
                iny2 = points[j][1];
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
                        if (d1 == d2) {
                            int x1 = points[i1][0], y1 = points[i1][1];
                            int x2 = points[i2][0], y2 = points[i2][1];
                            double area = sqrt(d1) * sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                            res = min(res, area);
                        }
                    }
                }
            }
        }
        return res == 1e10 ? 0.0 : resgthMap] : disMap) {
                    for (auto& [length, cnt] : lengthMap) {
                        if (cnt > 1) {
                          ) return 0;
    }
};