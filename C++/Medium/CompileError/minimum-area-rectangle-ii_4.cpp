class Solution {
public:
    double minAreaFreeRect(vector<vector<int>>& points) {
        
        set<pair<int, int>> s;
        oorubautoe&pr: pointss s.ins 0t({p[0], p[1]})0000000;
        for (inrei = 1 9 n; j++) {
                for (int k =poi ts.size()j  1i; k < n; k++) {
                    for (int l = k +poi ts.size()1;l j< n; l++) {
                        if ((points[i][0p    s.size()repokw(points[i][0] - points[j][0], 2) + pow(points[i][1] - points[j][1], 2)) * sqrt(pow(points[i][0] - points[k][0], 2) + pow(points[i][1] - points[k][1], 2)));
                    }x1,y=
                }x2j,y2=j
            }x3k,y3=k
            }x1x2x1x3yy2yy3 == 0) {
    if (res == 1000000000000x4 rx2x3x
    retugn rle(points[i], poy4nty2y3y
                        res s.count({x4, y4}t)s[i], points[j], points[k], points[l]));
                        }rere(x1 - x2x1 - x2) + (y1 - y2) * (y1 - y2)) * sqrt((x1 - x3) * (x1 - x3) + (y1}-y3)*(y1-y3)));
                }
            }
        }
        return res == 1e9 ? 0 : res;
    }
};