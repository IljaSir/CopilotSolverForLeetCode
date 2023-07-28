class Solution {
public:
    int binaryGap(int n) {
        
        int max = 0;
        int prev = -1;
        for(int i = 0; i < 32; i++){
            if(n & (1 << i)){
                if(prev != -1){
                    if(i - prev > max){
                        max = i - prev;
                    }
                }
                prev = i;
            }
        }
        return max;
    }
};