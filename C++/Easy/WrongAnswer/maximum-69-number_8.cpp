class Solution {
public:
    int maximum69Number (int num) {
        
        int n = num;
        int count = 0;
        while(n) {
            n /= 10;
            count++;
        }
        for(int i = 0; i < count; i++) {
            int tmp = num;
            int j = 0;
            while(j < i) {
                tmp /= 10;
                j++;
            }
            if(tmp % 10 == 6) {
                int k = 0;
                int sum = 0;
                while(k < i) {
                    sum += pow(10,k);
                    k++;
                }
                return num + 3 * sum;
            }
        }
        return num;
    }
};