class Solution {
public:
    bool reorderedPowerOf2(int n) {
        
        int a[10] = {0};
        while(n){
            a[n%10]++;
            n/=10;
        }
        for(int i=0;i<31;i++){
            int b[10] = {0};
            int x = 1<<i;
            while(x){
                b[x%10]++;
                x/=10;
            }
            int j;
            for(j=0;j<10;j++){
                if(a[j]!=b[j]){
                    break;
                }
            }
            if(j==10){
                return true;
            }
        }
        return false;
    }
};