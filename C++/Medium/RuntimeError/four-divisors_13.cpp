class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            int count = 0;
            int divisors[4] = {0};
            for (int j = 1; j <= sqrt(num); j++) {
                if (num % j == 0) {
                    if (j == num / j) {
                        divisors[count++] = j;
                    } else {
                        divisors[count++] = j;
                        divisors[count++] = num / j;
                    }
                }
            }
            if (count == 4) {
                for (int j = 0; j < 4; j++) {
                    sum += divisors[j];
                }
            }
        }
        return sum;
    }
};