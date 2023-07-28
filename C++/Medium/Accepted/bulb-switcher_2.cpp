class Solution {
public:
    int bulbSwitch(int n) {
        
        int i = 1;
        int sum = 0;
        while (i * i <= n) {
            sum++;
            i++;
        }
        return sum;
    }
};