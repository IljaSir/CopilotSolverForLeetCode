class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        vector<vector<int>> res;
        int n = buildings.size();
        if (n == 0) return res;
        if (n == 1) {
            res.push_back({buildings[0][0], buildings[0][2]});
            res.push_back({buildings[0][1], 0});
            return res;
        }
        vector<vector<int>> leftSkyline = getSkyline(vector<vector<int>>(buildings.begin(), buildings.begin() + n / 2));
        vector<vector<int>> rightSkyline = getSkyline(vector<vector<int>>(buildings.begin() + n / 2, buildings.end()));
        return mergeSkyline(leftSkyline, rightSkyline);
    }
    vector<vector<int>> mergeSkyline(vector<vector<int>>& leftSkyline, vector<vector<int>>& rightSkyline) {
        vector<vector<int>> res;
        int n = leftSkyline.size(), m = rightSkyline.size();
        int i = 0, j = 0;
        int leftH = 0, rightH = 0;
        while (i < n && j < m) {
            if (leftSkyline[i][0] < rightSkyline[j][0]) {
                leftH = leftSkyline[i][1];
                res.push_back({leftSkyline[i][0], max(leftH, rightH)});
                i++;
            } else if (leftSkyline[i][0] > rightSkyline[j][0]) {
                rightH = rightSkyline[j][1];
                res.push_back({rightSkyline[j][0], max(leftH, rightH)});
                j++;
            } else {
                leftH = leftSkyline[i][1];
                rightH = rightSkyline[j][1];
                res.push_back({leftSkyline[i][0], max(leftH, rightH)});
                i++;
                j++;
            }
        }
        while (i < n) {
            res.push_back(leftSkyline[i++]);
        }
        while (j < m) {
            res.push_back(rightSkyline[j++]);
        }
        return res;
    }
};