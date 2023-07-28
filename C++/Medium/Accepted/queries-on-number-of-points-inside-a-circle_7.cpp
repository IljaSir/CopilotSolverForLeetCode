class Solution {
public:
    vector<int> countPoints(vector<vector<int>>& points, vector<vector<int>>& queries) {
        
        int n = points.size();
        int m = queries.size();
        vector<int> res(m, 0);
        for(int i = 0; i < m; i++)
        {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];
            for(int j = 0; j < n; j++)
            {
                int x1 = points[j][0];
                int y1 = points[j][1];
                if((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y) <= r * r)
                    res[i]++;
            }
        }
        return res;
    }
};