class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        vector<int> digits(100, 0);
        for (int num: nums) {
            int sum = 0;
            for (int n = num; n > 0; n /= 10)
                sum += n % 10;
            digits[sum] = max(digits[sum], num);
        }
        int ans = -1;
        for (int i = 0; i < 100; ++i)
            for (int j = i; j < 100; ++j)
                if (i == j)
                    ans = max(ans, digits[i] + digits[j]);
                else
                    ans = max(ans, 2 * digits[i]);
        return ans;
    }
};