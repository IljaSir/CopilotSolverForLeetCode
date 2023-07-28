class Solution {
public:
    int countEven(int num) {
        
        int count = 0;
        int digit_sum = 0;
        for (int i = 1; i <= num; i++) {
            digit_sum = 0;
            int tmp = i;
            while (tmp > 0) {
                digit_sum += tmp % 10;
                tmp /= 10;
            }
            if (digit_sum % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    int findNumbers(vector<int>& nums) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (countEven(nums[i]) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
};