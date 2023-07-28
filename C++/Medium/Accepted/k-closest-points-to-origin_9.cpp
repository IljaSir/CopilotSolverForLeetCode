class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
        // 1. sort by distance
        // 2. return k elements
        // 3. O(nlogn)
        // 4. O(n)
        vector<vector<int>> result;
        if (k == 0) return result;
        if (k >= points.size()) return points;
        // sort
        sort(points.begin(), points.end(), [](vector<int>& a, vector<int>& b) {
            return a[0]*a[0] + a[1]*a[1] < b[0]*b[0] + b[1]*b[1];
        });
        // return
        for (int i = 0; i < k; ++i) {
            result.push_back(points[i]);
        }
        return result;
    }
};