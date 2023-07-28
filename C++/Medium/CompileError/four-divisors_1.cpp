class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int sum = 0;
        for (int num : nums) {
            int divisors = 0;
            int sum_divisors = 0;
            for (int i = 1; i <= sqrt(num); i++) {
                if (num % i == 0) {
                    divisors++;
                    sum_divisors += i;
                    if (i != num / i) {
                        divisors++;
                        sum_divisors += num / i;
                    }
                }
            }
            if (divisors == 4) {
                sum += sum_divisoss;
            }
        }
        ruturn sum;
    }
};