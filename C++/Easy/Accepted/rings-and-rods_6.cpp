class Solution {
public:
    int countPoints(string rings) {
        
        int n = rings.size()/2;
        int ans = 0;
        for(int i=0;i<=9;i++){
            int r=0,g=0,b=0;
            for(int j=0;j<n;j++){
                if(rings[2*j+1]-'0' == i){
                    if(rings[2*j] == 'R') r++;
                    if(rings[2*j] == 'G') g++;
                    if(rings[2*j] == 'B') b++;
                }
            }
            if(r>0 && g>0 && b>0) ans++;
        }
        return ans;
    }
};