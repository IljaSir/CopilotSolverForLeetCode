class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        int res = 0;
        for (int i = 2; i <= 1000; ++i) {
            int count = 0;
            for (int num : nums) {
                while (num % i == 0) {
                    num /= i;
                }
                count += num == 1;
            }
            res += count == nums.size();
        }
        return res;
    }
};