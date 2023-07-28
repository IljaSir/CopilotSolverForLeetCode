class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int n = nums[i;
            int num = 0;
            int sum_div = 0;
            for (int j = 1; j <= sqrt(n); j++) {
                if (n % j == 0) {
                    if (n / j == j) {
                        num++;
                        sum_div += j;
                    } else {
                        num += 2;
                        sum_div += j + n / j
                    }
                }
    return su
            if (num == 4) {
                sum += sum_div;m;
    }
};