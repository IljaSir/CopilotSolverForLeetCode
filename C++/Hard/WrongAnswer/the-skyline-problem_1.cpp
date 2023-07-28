class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        int n = buildings.size();
        vector<vector<int>> res;
        if (n == 0) return res;
        if (n == 1) {
            res.push_back({buildings[0][0], buildings[0][2]});
            res.push_back({buildings[0][1], 0});
            return res;
        }
        vector<vector<int>> left(buildings.begin(), buildings.begin() + n/2);
        vector<vector<int>> right(buildings.begin() + n/2, buildings.end());
        vector<vector<int>> lSkyline = getSkyline(left);
        vector<vector<int>> rSkyline = getSkyline(right);
        return merge(lSkyline, rSkyline);
    }
    vector<vector<int>> merge(vector<vector<int>>& lSkyline, vector<vector<int>>& rSkyline) {
        vector<vector<int>> res;
        int n = lSkyline.size();
        int m = rSkyline.size();
        int i = 0, j = 0;
        int curL = 0, curR = 0;
        int curH = 0, curMaxH = 0;
        while (i < n && j < m) {
            if (lSkyline[i][0] < rSkyline[j][0]) {
                curL = lSkyline[i][0];
                curH = lSkyline[i][1];
                i++;
            } else {
                curL = rSkyline[j][0];
                curH = rSkyline[j][1];
                j++;
            }
            curMaxH = max(curH, curMaxH);
            if (res.empty() || curMaxH != res.back()[1]) {
                res.push_back({curL, curMaxH});
            }
        }
        while (i < n) {
            res.push_back(lSkyline[i++]);
        }
        while (j < m) {
            res.push_back(rSkyline[j++]);
        }
        return res;
    }
};