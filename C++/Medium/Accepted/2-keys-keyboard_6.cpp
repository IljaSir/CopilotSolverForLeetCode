class Solution {
public:
    int minSteps(int n) {
        
        int i = 2;
        int count = 0;
        while(n > 1){
            while(n % i == 0){
                count += i;
                n /= i;
            }
            i++;
        }
        return count;
    }
};