class Solution {
public:
    vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
        
        vector<int> res;
        double max_val = 0;
        for(int x = 0; x <= 50; x++){
            for(int y = 0; y <= 50; y++){
                double q = 0;
                for(int i = 0; i < towers.size(); i++){
                    double d = sqrt((towers[i][0] - x) * (towers[i][0] - x) + (towers[i][1] - y) * (towers[i][1] - y));
                    if(d <= radius){
                        q += towers[i][2] / (1 + d);
                    }
                }
                if(q > max_val){
                    max_val = q;
                    res = {x, y};
                }
            }
        }
        return res;
    }
};