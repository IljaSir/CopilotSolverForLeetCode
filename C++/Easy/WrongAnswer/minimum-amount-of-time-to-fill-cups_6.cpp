class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int res = 0;
        while(amount[0] || amount[1] || amount[2]){
            if(amount[0] && amount[1] && amount[2]){
                int min = std::min(amount[0], amount[1]);
                res += min;
                amount[0] -= min;
                amount[1] -= min;
                amount[2] -= min;
            }else if(amount[0] && amount[1]){
                int min = std::min(amount[0], amount[1]);
                res += min;
                amount[0] -= min;
                amount[1] -= min;
            }else if(amount[1] && amount[2]){
                int min = std::min(amount[1], amount[2]);
                res += min;
                amount[1] -= min;
                amount[2] -= min;
            }else if(amount[0] && amount[2]){
                int min = std::min(amount[0], amount[2]);
                res += min;
                amount[0] -= min;
                amount[2] -= min;
            }else if(amount[0]){
                res += amount[0];
                amount[0] = 0;
            }else if(amount[1]){
                res += amount[1];
                amount[1] = 0;
            }else if(amount[2]){
                res += amount[2];
                amount[2] = 0;
            }
        }
        return res;
    }
};