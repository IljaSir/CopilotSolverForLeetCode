class Solution {
public:
    vector<int> countPoints(vector<vector<int>>& points, vector<vector<int>>& queries) {
        
        vector<int> res;
        for(auto& q : queries) {
            int x = q[0], y = q[1], r = q[2];
            int cnt = 0;
            for(auto& p : points) {
                int dis = (p[0]-x)*(p[0]-x) + (p[1]-y)*(p[1]-y);
                if(dis <= r*r) cnt++;
            }
            res.push_back(cnt);
        }
        return res;
    }
};