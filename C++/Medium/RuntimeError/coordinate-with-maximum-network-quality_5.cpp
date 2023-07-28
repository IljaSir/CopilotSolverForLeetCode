class Solution {
public:
    vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
        
        int max = 0;
        vector<int> res;
        for(int i = 0; i < 51; i++){
            for(int j = 0; j < 51; j++){
                int sum = 0;
                for(int k = 0; k < towers.size(); k++){
                    int d = sqrt(pow(i - towers[k][0], 2) + pow(j - towers[k][1], 2));
                    if(d <= radius){
                        sum += floor(towers[k][2] / (1 + d));
                    }
                }
                if(sum > max){
                    max = sum;
                    res = {i, j};
                }else if(sum == max){
                    if(i < res[0]){
                        res = {i, j};
                    }else if(i == res[0] && j < res[1]){
                        res = {i, j};
                    }
                }
            }
        }
        return res;
    }
};