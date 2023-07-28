class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int ans = 0;
        for (int num: nums) {
            int n = sqrt(num);
            int sum = 1 + num;
            int count = 2;
            for (int i = 2; i <= n; i++) {
                if (num % i == 0) {
                    sum += i;
                    sum += num / i;
                    count += 2;
                }
                if (count > 4) {
                    break;
                }
            }
            if (count == 4) {
                ans += sum;
            }
        }
        return ans;
    }
};