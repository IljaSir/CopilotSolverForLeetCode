class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int res = 0;
        for (auto& num : nums) {
            int div = 0, sum = 0;
            for (int i = 1; i * i <= num; ++i) {
                if (num % i == 0) {
                    div += 2;
                    sum += i;
                    if (i * i != num) {
                        sum += num / i;
                    }
                }
                if (div > 4) {
                    break;
                }
            }
            if (div == 4) {
                res += sum;
            }
        }
        return res;
    }
};