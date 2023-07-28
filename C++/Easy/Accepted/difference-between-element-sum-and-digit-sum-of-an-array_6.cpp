class Solution {
public:
    int differenceOfSum(vector<int>& nums) {
        
        int sum = 0, digitSum = 0;
        for (auto num: nums) {
            sum += num;
            while (num) {
                digitSum += num % 10;
                num /= 10;
            }
        }
        return abs(sum - digitSum);
    }
};