class Solution {
public:
    vector<int> countPoints(vector<vector<int>>& points, vector<vector<int>>& queries) {
        
        vector<int> ans;
        for(auto& q: queries){
            int x = q[0], y = q[1], r = q[2];
            int count = 0;
            for(auto& p: points){
                int dx = x - p[0];
                int dy = y - p[1];
                if(dx*dx + dy*dy <= r*r){
                    count++;
                }
            }
            ans.push_back(count);
        }
        return ans;
    }
};