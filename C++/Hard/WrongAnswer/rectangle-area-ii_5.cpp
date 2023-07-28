class Solution {
public:
    int rectangleArea(vector<vector<int>>& rectangles) {
        
        vector<pair<int,int>> h;
        for (auto& r:rectangles) {
            h.push_back({r[1], r[3]});
            h.push_back({r[1], -r[3]});
        }
        sort(h.begin(), h.end());
        int area = 0;
        for (int i=0; i<h.size(); ++i) {
            int j = i+1;
            while (j<h.size() && h[j].first==h[i].first) ++j;
            area += (h[i].first-h[i].second) * getArea(h, i, j);
            i = j-1;
        }
        return area;
    }
    int getArea(vector<pair<int,int>>& h, int i, int j) {
        int area = 0, cnt = 0, last = 0;
        for (int k=i; k<j; ++k) {
            if (h[k].second>0) {
                if (cnt==0) last = h[k].first;
                ++cnt;
            } else {
                --cnt;
                if (cnt==0) area += h[k].first - last;
            }
        }
        return area;
    }
};