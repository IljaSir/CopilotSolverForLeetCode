class Solution {
public:
    vector<int> countRectangles(vector<vector<int>>& rectangles, vector<vector<int>>& points) {
        
        vector<int> res;
        vector<int> x, y;
        for (auto& r : rectangles) {
            x.push_back(r[0]);
            y.push_back(r[1]);
        }
        sort(x.begin(), x.end());
        sort(y.begin(), y.end());
        for (auto& p : points) {
            int n = upper_bound(x.begin(), x.end(), p[0]) - x.begin();
            int m = upper_bound(y.begin(), y.end(), p[1]) - y.begin();
            res.push_back(n * m);
        }
        return res;
    }
};