class Solution {
public:
    int countPoints(string rings) {
        
        int n = rings.size();
        int m = n/2;
        int ans = 0;
        for(int i = 0; i < 10; ++i){
            int r = 0;
            int g = 0;
            int b = 0;
            for(int j = 0; j < m; ++j){
                if(rings[2*j+1] - '0' == i){
                    if(rings[2*j] == 'R'){
                        r = 1;
                    }
                    else if(rings[2*j] == 'G'){
                        g = 1;
                    }
                    else{
                        b = 1;
                    }
                }
            }
            ans += r + g + b == 3;
        }
        return ans;
    }
};