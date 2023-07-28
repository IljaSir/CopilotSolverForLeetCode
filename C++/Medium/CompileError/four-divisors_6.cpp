class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int sum = 0;
        for (int n: nums) {
            int count = 0;
            int total = 0;
            for (int i = 1; i <= sqrt(n); i++) {
                if (n % i == 0) {
                    count++;
                    total += i;
                    if (i != n / i) {
                        count++;
                        total += n / i;
                    }
                }
            }
            if (count == 4) {
                sum += total;
            }
        }
        return sum;];
                }
            }
        }
        return sum;
    }
};