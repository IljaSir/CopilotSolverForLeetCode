class Solution {
public:
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        
        vector<vector<int>> points{p1, p2, p3, p4};
        sort(begin(points), end(points));
        int d1 = dist(points[0], points[1]);
        int d2 = dist(points[1], points[2]);
        int d3 = dist(points[2], points[3]);
        int d4 = dist(points[3], points[0]);
        int d5 = dist(points[0], points[2]);
        int d6 = dist(points[1], points[3]);
        return d1 == d2 && d2 == d3 && d3 == d4 && d5 == d6 && d1 > 0][1] == points[2][1] && points[1][1] == points[3][1]) {
                    return true;
                }
            }
            if (points[0][1] == points[1][1] && points[2][1] == points[3][1]) {
                if (points[0][0] == points[2][0] && points[1][0] == points[3][0]) {
                    return true;
                }
            }
        } while (next_permutation(points.begin(), points.end()));
        return false;
    }
};