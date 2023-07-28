class Solution {
public:
    int rectangleArea(vector<vector<int>>& rectangles) {
        
        // 1. Sort the rectangles by x1
        // 2. For each rectangle, find the intersection of each rectangle
        //    with the rest of rectangles
        // 3. Calculate the area
        // 4. Repeat 1. 2. 3. until all rectangles are merged
        // 5. return the area
        const int MOD = 1e9 + 7;
        auto cmp = [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        };
        sort(rectangles.begin(), rectangles.end(), cmp);
        long long area = 0;
        for (int i = 0; i < rectangles.size(); i++) {
            vector<int> r = rectangles[i];
            for (int j = i + 1; j < rectangles.size(); j++) {
                vector<int> r2 = rectangles[j];
                if (r[0] == r2[0] && r[1] == r2[1] && r[2] == r2[2] && r[3] == r2[3]) {
                    continue;
                }
                if (r[2] <= r2[0] || r[3] <= r2[1] || r[0] >= r2[2] || r[1] >= r2[3]) {
                    continue;
                }
                // r2 is inside r
                if (r[0] <= r2[0] && r[1] <= r2[1] && r[2] >= r2[2] && r[3] >= r2[3]) {
                    rectangles[j][0] = r[0];
                    rectangles[j][1] = r[1];
                    rectangles[j][2] = r[2];
                    rectangles[j][3] = r[3];
                    continue;
                }
                // r is inside r2
                if (r2[0] <= r[0] && r2[1] <= r[1] && r2[2] >= r[2] && r2[3] >= r[3]) {
                    continue;
                }
                // r2 is on the left of r
                if (r2[2] <= r[0]) {
                    continue;
                }
                // r2 is on the
    }
};