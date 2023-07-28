class Solution {
public:
    int differenceOfSum(vector<int>& nums) {
        
        int elementSum = 0, digitSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            elementSum += nums[i];
            while (nums[i]) {
                digitSum += nums[i] % 10;
                nums[i] /= 10;
            }
        }
        return abs(elementSum - digitSum);
    }
};