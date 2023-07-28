class Solution {
public:
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        
        vector<vector<int>> points;
        points.push_back(p1);
        points.push_back(p2);
        points.push_back(p3);
        points.push_back(p4);
        sort(points.begin(), points.end());
        do {
            if (points[0][0] == points[1][0] && points[1][0] == points[2][0] && points[2][0] == points[3][0]) {
                if (points[0][1] == points[1][1] && points[1][1] == points[2][1] && points[2][1] == points[3][1]) {
                    return false;
                }
                if (points[0][1] == points[1][1] && points[2][1] == points[3][1]) {
                    return true;
                }
            }
            if (points[0][1] == points[1][1] && points[1][1] == points[2][1] && points[2][1] == points[3][1]) {
                if (points[0][0] == points[1][0] && points[1][0] == points[2][0] && points[2][0] == points[3][0]) {
                    return false;
                }
                if (points[0][0] == points[1][0] && points[2][0] == points[3][0]) {
                    return true;
                }
            }
            if (points[0][0] == points[1][0] && points[2][0] == points[3][0]) {
                if (points[0][1] == points[2][1] && points[1][1] == points[3][1]) {
                    return true;
                }
            }
            if (points[0][1] == points[1][1] && points[2][1] == points[3][1]) {
               if ([0]0] == points[][0 && points[1][0] == points[3][0]) {
                    return true;
                }
            }
        } while (next_permutation(points.begin(, points.end()))
        return false;        vector<vector<int>> points = {p1, p2, p3, p4};

        sort(points.begin(), points.end());
        if (points[0] == points[1] || points[1] == points[2] || points[2] == points[3]) {
            return false;
        }
        return dist(points[0], points[1]) == dist(points[1], points[3]) && dist(points[1], points[3]) == dist(points[3], points[2]) && dist(points[3], points[2]) == dist(points[2], points[0]) && dist(points[0], points[3]) == dist(points[1], points[2]);
    }
};