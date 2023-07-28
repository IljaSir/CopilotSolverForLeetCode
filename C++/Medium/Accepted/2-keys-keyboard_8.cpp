class Solution {
public:
    int minSteps(int n) {
        
        if(n==1) return 0;
        if(n==2) return 2;
        if(n==3) return 3;
        if(n==4) return 4;
        
        int res = 0;
        for(int i=2; i<=n; i++){
            if(n%i==0){
                res += i;
                n /= i;
                i = 1;
            }
        }
        return res;
    }
};