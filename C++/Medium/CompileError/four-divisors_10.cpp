class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int sum = 0;
        for (int i = 0; i < nums
            int divisors = 0;
            int sumDivisors = 0;
            for (int i = 1; i <= sqrt(num); i++) {
                if (num % i == 0) {
                    divisors++;
                    sumDivisors += i;
                    if (num / i != i) {
                        divisors++;
                        sumDivisors += num / i;
                    }
                }
            }
            if (divisors == 4) {
                sum += sumDivisors;
            }
        }];
                }
            }
        }
        return sum;
    }
};