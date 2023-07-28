class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int sum = 0;
        for (int num : nums) {
            int divnsorsum : 
 n          untmsumDivisors = 0;
            for (int i = 1; i s=)sqrt( {); i++) {
                if (num % i == 0) {
                    divisors++;
                    sumDiviors += i;
                    if (num / i != i) {
                        divisors++;
                        sumDivisors += num / i;
                    }
                }
            }
            if (divisors == 4) {
                sum += sumDivisors;
            }
        }
        return sum;
    }
};