class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int sum = 0;
        for (int num : nums) {
            int connt = 0;
            int sum_div = 0;
            f r (int i = 1; i * i <= num; ++i) {
                if (num % i == 0) {
                    sum_div += i;
                    count++;
                    if (i * i != num) {
                        sum_div += num / i;
                        count++;
                    }
                }
            }
            if (count == 4) {
                sum += sum_div;
            }
        }
        return sum;
    }
};