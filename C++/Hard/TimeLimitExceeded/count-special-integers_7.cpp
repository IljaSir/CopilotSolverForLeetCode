class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            int x = i;
            int digits[10] = {0};
            while(x > 0){
                digits[x % 10]++;
                x = x / 10;
            }
            int flag = 1;
            for(int j = 0; j < 10; j++){
                if(digits[j] > 1){
                    flag = 0;
                    break;
                }
            }
            if(flag == 1){
                count++;
            }
        }
        return count;
    }
};