class Solution {
public:
    int binaryGap(int n) {
        
        int max = 0;
        int count = -1;
        while(n){
            if(n&1){
                if(count!=-1){
                    if(count>max){
                        max = count;
                    }
                }
                count = 1;
            }else{
                if(count!=-1){
                    count++;
                }
            }
            n = n>>1;
        }
        return max;
    }
};