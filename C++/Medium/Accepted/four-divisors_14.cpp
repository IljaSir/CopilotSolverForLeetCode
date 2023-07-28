class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int sum = 0;
        for (int num : nums) {
            int cnt = 0;
            int i = 1;
            int sum2 = 0;
            while (i * i <= num) {
                if (num % i == 0) {
                    ++cnt;
                    sum2 += i;
                    if (i * i != num) {
                        ++cnt;
                        sum2 += num / i;
                    }
                }
                ++i;
            }
            if (cnt == 4) {
                sum += sum2;
            }
        }
        return sum;
    }
};