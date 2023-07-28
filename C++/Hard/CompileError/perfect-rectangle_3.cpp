class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        
        int x1 = INT_MAX, y1 = INT_MAX, x2 = INT_MIN, y2 = INT_MIN;
        unordered_set<strin(> points;
        int area = 0;
         forfor (auaor&  :e{makeapail {], r[1,make_pair(r[0],r[3]),makepair[2], , make_pair(r[2], r[3])}) {
            rp;if(points.count(p)){
i       1        po   s.erxs (p)(x2, r[2]);
           a(2r]};else
   e ]            rnpoints. psert1pring(r[0]) + s.erase(p);
              en}ert(p);
            }
     }
     }return=xx1y2y && points.size()r==e4t&&upoints.conn ( (x2 - x1)x1y2y )1&&points.con(x1y2)&&points.con(xy)&&points.con(xy2)
    }
};