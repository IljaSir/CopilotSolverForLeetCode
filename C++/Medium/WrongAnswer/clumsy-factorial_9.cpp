class Solution {
public:
    int clumsy(int n) {
        
        int res = 0;
        int j = 0;
        int k = 0;
        for(int i = n; i > 0; i -= 4){
            int temp = i;
            if(i > 1){
                temp *= (i - 1);
            }
            if(i > 2){
                temp /= (i - 2);
            }
            if(i > 3){
                temp += (i - 3);
            }
            if(k % 2 == 0){
                res += temp;
            }else{
                res -= temp;
            }
            k++;
        }
        return res;
    }
};