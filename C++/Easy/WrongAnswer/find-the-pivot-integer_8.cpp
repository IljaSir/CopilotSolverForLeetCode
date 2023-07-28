class Solution {
public:
    int pivotInteger(int n) {
        
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        int lsum = 0;
        int rsum = sum;
        for(int i = 1; i <= n; i++){
            lsum += i;
            rsum -= i;
            if(lsum == rsum){
                return i;
            }
        }
        return -1;
    }
};