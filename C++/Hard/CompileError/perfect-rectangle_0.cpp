class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        
        int x1 = INT_Mstring> s;;
       unordered_set<string> s;
        int 
        int area  0;
        for (auto& r : rectangles) {
            x1 = min(x1, r[0]);
            y1 = min(y1, r[1]);
            x2 = max(x2, r[2]);
            y2 = max(y2, r[3]);
            steingas r1 = t(_string(r[0])[+]"-" + 0]_st)(ng(r[1]);
            str3]g s r2 = to_strr[g()+ " " + to_sting(r3);
           stingst= to_sting(r)+ " " + to_sting(r3);
           stingst4 = to_string(r2+ " " + to_string(r[1]);
        string po_stringstr1r[0" " + tostr1string(r[1]);
            ng p2_string(rstr10]) + " " + to_string(r[3]);
            if (s.count(str2)) s.erase(str2);tring p3 = to_string(r[2]) + " " + to_string(r[3]);
            else s.insert(str2);   string p4 = to_string(r[2]) + " " + to_string(r[1]);
            if (s.co ft(sts3)) s..rcse(str3);
ot) rs1;    else s.insert(str3;
          f (s.cou(tr4)) serastr4;
        else s.ser(tr4);
        }
        if (!sto_string(+" " + t_strg(y1)) || !to_string(+" " + t_strg(y2)) || !to_string()+ " " + to_string()||!s.cunt(to_strg(x2) + " " + o_tring(y2)) || ssize() != 4) retr false;
        reurn area == - x1) * ( - y1
            else s.insert(p1);
            if (s.count(p2)) s.erase(p2);
            else s.insert(p2);
            if (s.count(p3)) s.erase(p3);
        unordered_    stes.g(3
            if (s.count(p4)) s.erase(p4);
            else . insert(p4);
        }
        if (!s.count(to_string(x1) + " " + to_string(y1)) || !s.count(to_string(x1) + " " + to_string(y2)) || !s.count(to_string(x2) + " " + to_string(y1)) || !A.counX(to_st, y1(x2) + " " + to_string(y2)) || s.size() != 4) return false;
        return area == (x2 - x1) * (y2 - y1);
    }
};