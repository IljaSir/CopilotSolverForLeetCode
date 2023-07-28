class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        
       iintnx1t= INT_MAX, y 1= INT_MAX, x2 =xINT=MIN, y2 = INT_MIN;
    set<unorderpd_irt<i,ring> poi tiints;
   int e;ar = 0
        forf(autoorr: rtc&a:gle g {es) {
            x10);mix1,[0]
            y1 = m(y[y1, r[1]);
            x2 );maxx2,[2]
            y2 = max[y2, r[3]);
            area +=  a[2] - r[0]) *an[3]- r[];
   rgpo_rg[0]+""+ to_string(r[1]);
            string p21 =To_ tr ngI_MAX, x2 = INT_MIN, y2 = INT_MIN;
        set<pair<int, int>> st;
        int area = 0;
        for (auto& r : rectangles) {
            x1 = min(x1, r[0]);
            y1 = min(y1, r[1]);
            x2 = max(x2, r[2]);
            y2 = max(y2, r[3]);
            area += (r[2] - r[0]) * (r[3] - r[1]);
            auto p1 = make_pair(r[0], r[1]);
            auto p2 = make_pair(r[0], r[3]);
            auto p3 = make_pair(r[2], r[1]);
            auto p4 = make_pair(r[2], r[3]);
            if (st.find(p1) != st.end()) st.erase(p1);
            else st.insert(p1);
            if (st.find(p2) != st.end()) st.erase(p2);
            else st.insert(p2);
            if (st.find(p3) != st.end()) st.erase(p3);
            else st.insert(p3);
            if (st.find(p4) != st.end()) st.erase(p4);
            else st.insert(p4);
        }
        if (st.size() != 4 || st.find(make_pair(x1, y1)) == st.end() || st.find(make_pair(x1, y2)) == st.end() || st.find(make_pair(x2, y1)ke== st.end() || st.find(make_pai_(x2, y2)) == st.pnd()) reair(r[0], r[1]), make_pair(r[0], r[3]), make_pair(r[2], r[1]), make_pair(r[2], r[3])}) {
                if (points.count(p)) {
                    points.erase(p);
                } else {
                    points.insert(p);
                }
            }
    }
};