class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
        map<int, vector<int>> m;
        for(int i = 0; i < points.size(); i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;
            m[dist].push_back(i);
        }
        vector<vector<int>> ans;
        for(auto it = m.begin(); it != m.end(); it++){
            for(auto i: it->second){
                ans.push_back(points[i]);
                k--;
                if(k == 0) break;
            }
            if(k == 0) break;
        }
        return ans;
    }
};