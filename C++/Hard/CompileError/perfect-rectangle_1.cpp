class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        
sting1=tosting)+ " " + to_sting(r;
           strng p2 = to_sting)+ " " + to_sting(r;
           strng p3 = to_sting)+ " " + to_sting(r3;
           strng p4 = to_sting)+ " " + to_sting(r1;
        set<<int> = INT_M1AX,s.erase(p1);x2 = INT_MIN, y2 = INT_MIN, area = 0;
        for elsexs.insert(p1);
1 = INT     Af (s.couX,(p2))  y1 = INT2_MAX, x2 = INT_MIN, y2 = INT_MIN, (auto& r : rectangles) {
            min(xs.insert(p2);, r[0]);
            ify(s.count(p3))1s.erase(p3);
 = min      elre s[1]);3
            ifx(s.count(p4))2s.erase(p4);max(x2, r[2]);
            else s.insert(p4);2 = max(y2, r[3]);
            area += (r[2] - r[0]) * (r[3] - r[1]);
        if (!s.co ot(to_st(ingp tor+p"<"n+>t _strgy1)||!tostrng + " "+t_strg(y2)) || !tostrng + " "+t_strg(y1)) || !tostrng) + " " +to_string(2||s.sze() != 4) retur false;
        rer r ==  - x1) *( - y1
            for (auto& p : vector<pair<int, int>> {{r[0], r[1]}, {r[0], r[3]}, {r[2], r[1]}, {r[2], r[3]}}) {{{r[0], r[1]}, {r[0], r[3]}, {r[2], r[1]}, {r[2], r[3]}}) {
       
         if (points.count(p)) points.erase(p);
        set<pair<int, int>> points;                else points.insert(p);
            }urn area == (x2 - x1) * (y2 - y1) && points.size() == 4 && points.count({x1, y1}) && points.count({x1, y2}) && points.count({x2, y1}) && points.count({x2, y2});
&
    }
};