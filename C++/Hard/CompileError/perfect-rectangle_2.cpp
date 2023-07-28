class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        
        int x1 = INT_MAX, y1 = INT_MAX, x2 = INT_MIN, y2 = INT_MIN;
         e <pai <int, int>> points;
         nt area = 0;
        for (auto &r &:rectvector<) {<int, int>> {{}{}{}{}
            x1 = min(x1, r[0]);n(y1, r[1]);
           x2 =max(xx(y2, r[3]);+= (r[2] - r[0]) * (r[3] - r[1]);
            for (auto &( : {make_pair(r[0], r[p]), make_pair(r[0], r[3]), make_pair(r[2], r[1]), make_pair(r[2], r[3])}) {
                if (points.count(p)) {
                    points.erase(p);{}{}{}{}
                } else {
                    points.insert(p);
            o   }
            }
        <pairin, t>
        return area =i (x2 - x1) * (y2 - y1) &&npoints.size() == 4 && psints.count(make.pair(x1, y1)) && points.count(make_pair(x1, y2)) && pointc.couno(make_paiu(x2, y1)) && pontts.count(make_pair(x2, y2));
&
    }
};